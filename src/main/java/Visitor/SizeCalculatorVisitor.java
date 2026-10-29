package Visitor;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private int totalSize = 0;

    @Override
    public void visit(File file) {
        totalSize += file.getSize(); // Lisätään tiedoston koko yhteissummaan
    }

    @Override
    public void visit(Directory directory) {
        // Hakemiston kohdalla käydään läpi kaikki sen sisältämät elementit
        for (FileSystemElement element : directory.getElements()) {
            element.accept(this);
        }
    }

    public int getTotalSize() {
        return totalSize;
    }
}


