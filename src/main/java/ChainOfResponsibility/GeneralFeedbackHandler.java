package ChainOfResponsibility;

/**
 * Analyses general feedback with a simple keyword-based sentiment check
 * and chooses a reply accordingly.
 */
public class GeneralFeedbackHandler extends Handler {

    private static final String[] POSITIVE = {"great", "good", "love", "excellent", "thanks", "happy"};
    private static final String[] NEGATIVE = {"bad", "slow", "rude", "terrible", "disappointed", "annoying"};

    @Override
    protected boolean canHandle(Message message) {
        return message.getType() == MessageType.GENERAL_FEEDBACK;
    }

    @Override
    protected String process(Message message) {
        String text = message.getContent().toLowerCase();
        int score = count(text, POSITIVE) - count(text, NEGATIVE);

        String sentiment;
        String reply;
        if (score > 0) {
            sentiment = "positive";
            reply = "Thank you for your kind words!";
        } else if (score < 0) {
            sentiment = "negative";
            reply = "We're sorry to hear that and will look into it.";
        } else {
            sentiment = "neutral";
            reply = "Thank you for your feedback.";
        }
        return "General feedback analysed as " + sentiment + ". Reply to "
                + message.getSenderEmail() + ": \"" + reply + "\"";
    }

    private int count(String text, String[] words) {
        int hits = 0;
        for (String word : words) {
            if (text.contains(word)) {
                hits++;
            }
        }
        return hits;
    }
}
