package proxy;

public class RealDocument implements Document {
    private String id;
    private String creationDate;
    private String content;

    public RealDocument(String id, String creationDate, String content) {
        this.id = id;
        this.creationDate = creationDate;
        this.content = content;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getCreationDate() {
        return creationDate;
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        return content;
    }
}