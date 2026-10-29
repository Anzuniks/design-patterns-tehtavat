package proxy;

import java.util.HashSet;
import java.util.Set;

public class AccessControlService {
    private static AccessControlService instance;

    // Tallentaa sallitut parit muodossa "documentId:username"
    private Set<String> allowedAccess;

    private AccessControlService() {
        allowedAccess = new HashSet<>();
    }

    public static AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    // Apumetodi oikeuksien antamiseen (testausta varten)
    public void grantAccess(String documentId, String username) {
        allowedAccess.add(documentId + ":" + username);
    }

    public boolean isAllowed(String documentId, String username) {
        return allowedAccess.contains(documentId + ":" + username);
    }
}


