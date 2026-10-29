package proxy;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Document> documents;

    public Library() {
        this.documents = new HashMap<>();
    }

    // Tehdasmetodi suojaamattomalle dokumentille
    public void addUnprotectedDocument(String id, String creationDate, String content) {
        Document doc = new RealDocument(id, creationDate, content);
        documents.put(id, doc);
    }

    // Tehdasmetodi suojatulle dokumentille
    public void addProtectedDocument(String id, String creationDate, String content) {
        RealDocument realDoc = new RealDocument(id, creationDate, content);
        Document proxy = new DocumentProxy(realDoc); // Piilotetaan RealDocument Proxyn taakse
        documents.put(id, proxy);
    }

    public Document getDocument(String id) {
        return documents.get(id);
    }
}


