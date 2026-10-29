package proxy;

public interface Document {
    String getId();
    String getCreationDate();
    String getContent(User user) throws AccessDeniedException;
}
