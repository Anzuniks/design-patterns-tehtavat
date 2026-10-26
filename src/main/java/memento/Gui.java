package memento;

import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Gui {
    private Controller controller;
    private Rectangle[] colorBoxes;
    private CheckBox checkBox;
    private VBox layout;

    public Gui(Controller controller) {
        this.controller = controller;
        this.colorBoxes = new Rectangle[3];
        this.checkBox = new CheckBox("Checkbox");

        HBox boxLayout = new HBox(10);

        // Luodaan 3 suorakulmiota, joita klikkaamalla väri vaihtuu (0=Punainen, 1=Sininen, 2=Keltainen)
        for (int i = 0; i < 3; i++) {
            final int index = i;
            Rectangle rect = new Rectangle(50, 50, Color.RED);
            rect.setOnMouseClicked(e -> {
                int currentColor = controller.getModel().getColors()[index];
                int nextColor = (currentColor + 1) % 3;
                controller.getModel().setColor(index, nextColor);
                controller.saveState(); // Tallennetaan tila muutoksen jälkeen
                update();
            });
            colorBoxes[i] = rect;
            boxLayout.getChildren().add(rect);
        }

        checkBox.setOnAction(e -> {
            controller.getModel().setCheckBoxState(checkBox.isSelected());
            controller.saveState(); // Tallennetaan tila
        });

        layout = new VBox(20, boxLayout, checkBox);
        layout.setPadding(new Insets(20));
        update(); // Asetetaan alkutila
    }

    public VBox getLayout() {
        return layout;
    }

    // Päivittää käyttöliittymän vastaamaan Modelin tilaa (kutsutaan undo/redo yhteydessä)
    public void update() {
        int[] colors = controller.getModel().getColors();
        for (int i = 0; i < 3; i++) {
            if (colors[i] == 0) colorBoxes[i].setFill(Color.RED);
            else if (colors[i] == 1) colorBoxes[i].setFill(Color.BLUE);
            else if (colors[i] == 2) colorBoxes[i].setFill(Color.YELLOW);
        }
        checkBox.setSelected(controller.getModel().isCheckBoxState());
    }
}