package ChainOfResponsibility;

/**
 * Base class of the Chain of Responsibility pattern.
 *
 * Every handler keeps a reference to the next handler in the chain.
 * When a message arrives, the handler either processes it itself (if it
 * is responsible for that message type) or passes it on to the next one.
 * The client only talks to the first handler and never needs to know
 * which handler eventually does the work.
 */
public abstract class Handler {

    private Handler next;

    /**
     * Links the next handler and returns it, so a chain can be built
     * fluently: first.setNext(second).setNext(third);
     */
    public Handler setNext(Handler next) {
        this.next = next;
        return next;
    }

    /** Handles the message here, or forwards it down the chain. */
    public String handle(Message message) {
        if (canHandle(message)) {
            return process(message);
        }
        if (next != null) {
            return next.handle(message);
        }
        return "No handler found for message type " + message.getType();
    }

    /** True if this handler is responsible for the given message. */
    protected abstract boolean canHandle(Message message);

    /** The actual handling logic; returns a description of the result. */
    protected abstract String process(Message message);
}
