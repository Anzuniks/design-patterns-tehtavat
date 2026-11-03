package Builder;

public class ComputerDirector {
    private ComputerBuilder builder;

    public ComputerDirector(ComputerBuilder builder) {
        this.builder = builder;
    }

    // Asetetaan tarvittaessa uusi builder
    public void setBuilder(ComputerBuilder builder) {
        this.builder = builder;
    }

    // Suorittaa kokoamisvaiheet tietyssä järjestyksessä
    public Computer constructComputer() {
        builder.buildProcessor();
        builder.buildRAM();
        builder.buildHardDrive();
        builder.buildGraphicsCard();
        builder.buildOperatingSystem();
        return builder.getComputer();
    }
}

