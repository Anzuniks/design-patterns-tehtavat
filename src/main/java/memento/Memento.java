package memento;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Memento implements IMemento {
    // 1. Sovelluksen tilan tallentavat muuttujat
    private int[] colors;
    private boolean checkBoxState;

    // 2. Historiaikkunaa varten lisätty aikaleima
    private final String timestamp;

    // Konstruktori ottaa vastaan sen hetkisen tilan Modelilta
    public Memento(int[] colors, boolean checkBoxState) {
        // Kopioidaan taulukko, jotta myöhemmät muutokset eivät vahingossa muuta tätä tallennettua tilaa
        this.colors = colors.clone();
        this.checkBoxState = checkBoxState;

        // Luodaan aikaleima
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        this.timestamp = LocalDateTime.now().format(formatter);
    }

    // Metodit tilan palauttamista varten
    public int[] getColors() {
        return colors.clone();
    }

    public boolean getCheckBoxState() {
        return checkBoxState;
    }

    // IMemento-rajapinnan vaatima metodi
    @Override
    public String getTimestamp() {
        return this.timestamp;
    }

    // Historiaikkunan ListView käyttää tätä rivien näyttämiseen
    @Override
    public String toString() {
        return "Tila tallennettu: " + timestamp;
    }
}