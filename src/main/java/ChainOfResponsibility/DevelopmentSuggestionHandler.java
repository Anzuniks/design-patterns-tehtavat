package ChainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

/** Logs development suggestions to a backlog and gives each a priority. */
public class DevelopmentSuggestionHandler extends Handler {

    private final List<String> backlog = new ArrayList<>();

    @Override
    protected boolean canHandle(Message message) {
        return message.getType() == MessageType.DEVELOPMENT_SUGGESTION;
    }

    @Override
    protected String process(Message message) {
        String priority = choosePriority(message.getContent().toLowerCase());
        backlog.add(priority + ": " + message.getContent());
        return "Development suggestion logged with priority " + priority
                + " (backlog item #" + backlog.size() + ").";
    }

    private String choosePriority(String text) {
        if (text.contains("crash") || text.contains("security") || text.contains("accessibility")) {
            return "HIGH";
        }
        if (text.contains("faster") || text.contains("easier") || text.contains("option")) {
            return "MEDIUM";
        }
        return "LOW";
    }

    public List<String> getBacklog() {
        return backlog;
    }
}
