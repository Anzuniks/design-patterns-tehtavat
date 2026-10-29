package Visitor;

public class Main {
    public static void main(String[] args) {
        // 1. Luodaan kansiorakenne ja tiedostoja
        Directory root = new Directory("Root");
        Directory documents = new Directory("Documents");
        Directory pictures = new Directory("Pictures");

        File doc1 = new File("assignment.pdf", 2);
        File doc2 = new File("notes.txt", 1);
        File pic1 = new File("vacation.jpg", 4);
        File pic2 = new File("profile_pic.png", 3);
        File pic3 = new File("dog.jpg", 5);

        // Lisätään tiedostot kansioihin
        documents.addElement(doc1);
        documents.addElement(doc2);

        pictures.addElement(pic1);
        pictures.addElement(pic2);
        pictures.addElement(pic3);

        // Kootaan puu Root-kansion alle
        root.addElement(documents);
        root.addElement(pictures);
        root.addElement(new File("readme.md", 1)); // Tiedosto suoraan juuressa

        System.out.println("--- Testataan SizeCalculatorVisitor ---");
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Tiedostojärjestelmän kokonaiskoko: " + sizeVisitor.getTotalSize() + " MB");

        System.out.println("\n--- Testataan SearchVisitor ---");
        String searchPattern = ".jpg";
        SearchVisitor searchVisitor = new SearchVisitor(searchPattern);
        root.accept(searchVisitor);

        System.out.println("Löydetyt tiedostot hakusanalla '" + searchPattern + "':");
        for (File file : searchVisitor.getFoundFiles()) {
            System.out.println("- " + file.getName() + " (" + file.getSize() + " MB)");
        }
    }
}


