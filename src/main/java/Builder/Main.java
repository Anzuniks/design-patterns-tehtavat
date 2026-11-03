package Builder;

public class Main {
    public static void main(String[] args) {
        // 1. Kasataan pelitietokone
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector director = new ComputerDirector(gamingBuilder);
        Computer gamingPC = director.constructComputer();

        System.out.println("=== PELITIETOKONE ===");
        System.out.println(gamingPC);

        // 2. Kasataan toimistotietokone vaihtamalla builderia
        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        director.setBuilder(officeBuilder);
        Computer officePC = director.constructComputer();

        System.out.println("=== TOIMISTOTIETOKONE ===");
        System.out.println(officePC);
    }
}

