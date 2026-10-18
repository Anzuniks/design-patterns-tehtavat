package ChainOfResponsibility;

import java.util.List;

/**
 * Builds the handler chain, sends different kinds of feedback into it
 * and prints how each message was handled.
 */
public class Main {

    public static void main(String[] args) {
        // Build the chain: compensation -> contact -> suggestion -> general
        CompensationClaimHandler compensation = new CompensationClaimHandler();
        DevelopmentSuggestionHandler suggestions = new DevelopmentSuggestionHandler();

        compensation
                .setNext(new ContactRequestHandler())
                .setNext(suggestions)
                .setNext(new GeneralFeedbackHandler());

        Handler chain = compensation; // the client only knows the first handler

        List<Message> messages = List.of(
                new Message(MessageType.COMPENSATION_CLAIM,
                        "My package arrived broken, I want 45 € back.", "anna@example.com"),
                new Message(MessageType.COMPENSATION_CLAIM,
                        "The laptop was faulty, please refund 899,90 €.", "mikko@example.com"),
                new Message(MessageType.COMPENSATION_CLAIM,
                        "I want compensation for the delay!", "laura@example.com"),
                new Message(MessageType.CONTACT_REQUEST,
                        "There is a wrong amount on my invoice, please call me.", "jussi@example.com"),
                new Message(MessageType.CONTACT_REQUEST,
                        "I get an error every time I try to login.", "sara@example.com"),
                new Message(MessageType.CONTACT_REQUEST,
                        "Can someone call me about opening hours?", "pekka@example.com"),
                new Message(MessageType.DEVELOPMENT_SUGGESTION,
                        "The app crash on startup should be fixed first.", "emma@example.com"),
                new Message(MessageType.DEVELOPMENT_SUGGESTION,
                        "Add an option to pay with MobilePay.", "ville@example.com"),
                new Message(MessageType.DEVELOPMENT_SUGGESTION,
                        "A dark mode would look nice.", "noora@example.com"),
                new Message(MessageType.GENERAL_FEEDBACK,
                        "Great service, I love the new store!", "tiina@example.com"),
                new Message(MessageType.GENERAL_FEEDBACK,
                        "Delivery was slow and the driver was rude.", "antti@example.com"),
                new Message(MessageType.GENERAL_FEEDBACK,
                        "I visited your shop yesterday.", "olli@example.com")
        );

        for (Message message : messages) {
            System.out.println(message);
            System.out.println("  -> " + chain.handle(message));
            System.out.println();
        }

        System.out.println("=== Development backlog ===");
        for (String item : suggestions.getBacklog()) {
            System.out.println("  " + item);
        }
    }
}
