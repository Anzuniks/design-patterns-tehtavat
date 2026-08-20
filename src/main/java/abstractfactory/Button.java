package abstractfactory;

public abstract class Button extends UIElement {
    //Button-luokka, joka perii UIElement-luokan ja toteuttaa sen abstraktin display-metodin.
    public Button(String text) {
        super(text);
    }
}
