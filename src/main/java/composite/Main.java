package composite;

public class Main {
    public static void main(String[] args) {
        //Luodaan organisaatio
        Department company = new Department("Quantix");

        Department engineering = new Department("Tuotekehitys");
        engineering.add(new Employee("Jere Lappalainen", 2000));
        engineering.add(new Employee("Teemu Poutanen", 2000));
        engineering.add(new Employee("Satvik Velpula", 2000));

        //Luodaan backend-tiimi ja lisätään se tuotekehitykseen
        Department backendTeam = new Department("Backend-tiimi");
        backendTeam.add(new Employee("Anders Nuri", 2000));
        engineering.add(backendTeam);

        Department myynti = new Department("Myynti");
        myynti.add(new Employee("Janne Kallio", 1500));
        myynti.add(new Employee("Janne Kallio", 2000));

        company.add(engineering);
        company.add(myynti);
        company.add(new Employee("Toimitusjohtaja Elina Uho", 1000));

        //Vaatimus 7: kokonaispalkka lasketaan rekursiivisesti
            System.out.println("Organisaation kokonaispalkka: " + company.getTotalSalary());

        //Vaatimus 8: XML-muotoon tulostus
        System.out.println("Organisaation XML-muotoinen esitys:\n" + company.toXml(0));
    }
}
