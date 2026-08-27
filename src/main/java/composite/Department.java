package composite;

import java.util.ArrayList;
import java.util.List;

public class Department implements OrganizationComponent {
    //Luodaan private muuttuja nimelle ja listalle alikomponentteja
    private final String name;
    private final List<OrganizationComponent> children = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void add(OrganizationComponent component) {
        children.add(component);
    }

    @Override
    public void remove(OrganizationComponent component) {
        children.remove(component);
    }

    @Override
    //Palkkalaskenta, joka käy läpi kaikki alikomponentit ja laskee niiden palkat yhteen
    public double getTotalSalary() {
        double total = 0;
        //child ja children ovat OrganizationComponent-tyyppisiä, joten voidaan kutsua getTotalSalary() kaikille lapsille
        for (OrganizationComponent child : children) {
            total += child.getTotalSalary();
        }
        return total;
    }

    @Override
    //Muuttaa osaston ja sen alikomponentit XML-muotoon
    public String toXml(int indentLevel) {
        //sb on StringBuilder, joka rakentaa xml-muotoisen merkkijonon. indentLevel määrittää sisennyksen määrän.
        String indent = " ".repeat(indentLevel);
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append("<department name=\"").append(name).append("\">\n");
        for (OrganizationComponent child : children) {
            sb.append(child.toXml(indentLevel + 2)).append("\n");
        }
        sb.append(indent).append("</department>");
        return sb.toString();
    }
}