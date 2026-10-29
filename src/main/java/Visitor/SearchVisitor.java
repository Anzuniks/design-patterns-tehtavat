package Visitor;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private String searchCriterion;
    private List<File> matchingFiles;

    public SearchVisitor(String searchCriterion) {
        this.searchCriterion = searchCriterion;
        this.matchingFiles = new ArrayList<>();
    }

    @Override
    public void visit(File file) {
        // Jos tiedoston nimi sisältää hakusanan, lisätään se listaan
        if (file.getName().contains(searchCriterion)) {
            matchingFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        // Hakemiston kohdalla välitetään Visitor edelleen sen lapsielementeille
        for (FileSystemElement element : directory.getElements()) {
            element.accept(this);
        }
    }

    public List<File> getFoundFiles() {
        return matchingFiles;
    }
}


