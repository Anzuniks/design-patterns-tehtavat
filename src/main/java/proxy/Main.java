package proxy;

public class Main {
    public static void main(String[] args) {
        // 1. Luodaan kirjasto ja käyttäjät
        Library library = new Library();
        User adminUser = new User("admin");
        User normiUser = new User("peruskäyttäjä");

        // 2. Luodaan dokumentteja kirjastoon
        library.addUnprotectedDocument("DOC-1", "2026-10-29", "Tämä on julkinen tiedote kaikille.");
        library.addProtectedDocument("DOC-2", "2026-10-29", "Tämä on salainen raportti.");

        // 3. Määritetään käyttöoikeudet Singleton-palveluun
        AccessControlService acs = AccessControlService.getInstance();
        acs.grantAccess("DOC-2", "admin"); // Vain admin saa lukea DOC-2:n

        // 4. Testataan skenaariot

        System.out.println("--- Testataan suojaamatonta dokumenttia ---");
        Document doc1 = library.getDocument("DOC-1");
        System.out.println("Dokumentin " + doc1.getId() + " luontipäivä: " + doc1.getCreationDate());

        try {
            System.out.println("Peruskäyttäjä yrittää lukea: " + doc1.getContent(normiUser));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- Testataan suojattua dokumenttia ---");
        Document doc2 = library.getDocument("DOC-2");
        System.out.println("Dokumentin " + doc2.getId() + " luontipäivä: " + doc2.getCreationDate());

        // Admin yrittää lukea
        try {
            System.out.println("Admin yrittää lukea: " + doc2.getContent(adminUser));
        } catch (AccessDeniedException e) {
            System.out.println("VIRHE: " + e.getMessage());
        }

        // Peruskäyttäjä yrittää lukea (Pitäisi heittää poikkeus)
        try {
            System.out.println("Peruskäyttäjä yrittää lukea...");
            System.out.println(doc2.getContent(normiUser));
        } catch (AccessDeniedException e) {
            System.out.println("VIRHE KIINNIOTETTU: " + e.getMessage());
        }
    }
}
