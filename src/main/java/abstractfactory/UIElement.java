package abstractfactory;

public abstract class UIElement {
    //Protected tarkoittaa, että tämä luokka ja sen aliluokat voivat käyttää tätä metodia, mutta muut luokat eivät voi.
    protected String text;

    public UIElement(String text) {
        this.text = text;
    }

    //Hoidetaan dynaaminen tekstin vaihto käyttöliittymässä. Tämä metodi on abstrakti, joten aliluokkien on toteutettava se.
    public void setText(String text) {
        this.text = text;
    }

    public abstract void display();
}
