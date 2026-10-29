package proxy;

public class DocumentProxy implements Document {
    private RealDocument document;

    public DocumentProxy(RealDocument document) {
        this.document = document;
    }

    @Override
    public String getId() {
        return document.getId(); // ID on aina julkinen
    }

    @Override
    public String getCreationDate() {
        return document.getCreationDate(); // Päivämäärä on aina julkinen
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        AccessControlService acs = AccessControlService.getInstance();

        if (acs.isAllowed(document.getId(), user.getUsername())) {
            // Jos lupa löytyy, välitetään pyyntö aidolle dokumentille
            return document.getContent(user);
        } else {
            // Muuten heitetään poikkeus
            throw new AccessDeniedException("Access denied for user: " + user.getUsername() + " to document: " + document.getId());
        }
    }
}


