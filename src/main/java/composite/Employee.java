package composite;

public class Employee implements OrganizationComponent {
    //Haetaan nimet ja palkat ja xml-tiedostosta
    private final String name;
    private final double salary;


    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getTotalSalary() {
        return salary;
    }

    @Override
    public String toXml(int indentLevel) {
        //Luodaan sisennys ja palautetaan xml-muotoinen merkkijono
        String indent = " ".repeat(indentLevel);
        return indent + "<employee name=\"" + name + "\" salary=\"" + salary + "\"/>";
    }
}
