package memento;

public class Model {
    // Tehtävänannon mukainen tila: 3 suorakulmion värit (0, 1 tai 2) ja checkboxin tila
    private int[] colors;
    private boolean checkBoxState;

    public Model() {
        // Alustetaan 3 suorakulmiota, joiden oletusvärikoodi on 0, ja checkbox on false
        this.colors = new int[]{0, 0, 0};
        this.checkBoxState = false;
    }

    // --- Tilan muuttaminen ja lukeminen ---

    public void setColor(int index, int colorCode) {
        if (index >= 0 && index < colors.length) {
            this.colors[index] = colorCode;
        }
    }

    public void setCheckBoxState(boolean state) {
        this.checkBoxState = state;
    }

    public int[] getColors() {
        return colors;
    }

    public boolean isCheckBoxState() {
        return checkBoxState;
    }

    // --- Mementon luonti ja palautus ---

    public IMemento createMemento() {
        // Lähetetään nykyinen tila Mementon konstruktorille
        return new Memento(this.colors, this.checkBoxState);
    }

    public void restoreState(IMemento memento) {
        // Palautetaan tila mementosta
        Memento mem = (Memento) memento;
        this.colors = mem.getColors();
        this.checkBoxState = mem.getCheckBoxState();

        // HUOM: Alkuperäisessä koodissa täällä todennäköisesti kutsuttiin
        // käyttöliittymän päivitystä, esim. gui.update();
        System.out.println("Tila palautettu: värit [" + colors[0] + "," + colors[1] + "," + colors[2] + "], checkbox: " + checkBoxState);
    }
}