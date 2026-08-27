package composite;

public interface OrganizationComponent {
  //Haetaan nimet ja palkat ja xml-tiedostosta
    String getName();
    double getTotalSalary();
    String toXml(int indentLevel);


//Oletustoteukset lehdelle Employee (ei tue)
default void add(OrganizationComponent component) {
    throw new UnsupportedOperationException("Ei voi lisätä lapsia tähän komponenttiin.");
}

default void remove(OrganizationComponent component) {
    throw new UnsupportedOperationException("Ei voi poistaa lapsia tästä komponentista.");
    }

}