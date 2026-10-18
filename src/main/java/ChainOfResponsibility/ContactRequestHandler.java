package ChainOfResponsibility;

/** Forwards contact requests to the department that matches their topic. */
public class ContactRequestHandler extends Handler {

    @Override
    protected boolean canHandle(Message message) {
        return message.getType() == MessageType.CONTACT_REQUEST;
    }

    @Override
    protected String process(Message message) {
        String department = chooseDepartment(message.getContent().toLowerCase());
        return "Contact request from " + message.getSenderEmail()
                + " forwarded to the " + department + " department.";
    }

    private String chooseDepartment(String text) {
        if (text.contains("invoice") || text.contains("payment") || text.contains("bill")) {
            return "Billing";
        }
        if (text.contains("error") || text.contains("login") || text.contains("bug")) {
            return "Technical Support";
        }
        if (text.contains("price") || text.contains("offer") || text.contains("buy")) {
            return "Sales";
        }
        return "Customer Service";
    }
}
