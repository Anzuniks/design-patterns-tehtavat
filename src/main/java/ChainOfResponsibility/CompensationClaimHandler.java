package ChainOfResponsibility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Reviews compensation claims. Claims up to the auto-approval limit are
 * approved, larger ones are sent to a manager, and claims that do not
 * state an amount are rejected.
 */
public class CompensationClaimHandler extends Handler {

    private static final double AUTO_APPROVAL_LIMIT = 100.0;

    /** Finds an amount such as "45", "45.50" or "45,50" followed by € or eur. */
    private static final Pattern AMOUNT = Pattern.compile(
            "(\\d+(?:[.,]\\d{1,2})?)\\s*(?:€|eur)", Pattern.CASE_INSENSITIVE);

    @Override
    protected boolean canHandle(Message message) {
        return message.getType() == MessageType.COMPENSATION_CLAIM;
    }

    @Override
    protected String process(Message message) {
        Matcher matcher = AMOUNT.matcher(message.getContent());
        if (!matcher.find()) {
            return "Compensation claim REJECTED: no claimed amount stated. "
                    + "Reply sent to " + message.getSenderEmail() + " asking for details.";
        }

        double amount = Double.parseDouble(matcher.group(1).replace(',', '.'));
        if (amount <= AUTO_APPROVAL_LIMIT) {
            return String.format("Compensation claim APPROVED: %.2f € refunded to %s.",
                    amount, message.getSenderEmail());
        }
        return String.format("Compensation claim of %.2f € exceeds the %.0f € limit: "
                + "sent to a manager for review.", amount, AUTO_APPROVAL_LIMIT);
    }
}
