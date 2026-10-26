package memento;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 1. Alustetaan sovelluksen ydinluokat
        Model model = new Model();
        Controller controller = new Controller(model);
        Gui gui = new Gui(controller);

        // Kytketään Gui ohjaimeen, jotta ohjain osaa päivittää ruudun (undo/redo)
        controller.setGui(gui);

        // 2. Luodaan Scene käyttämällä Gui-luokan rakentamaa ulkoasua
        Scene scene = new Scene(gui.getLayout(), 400, 300);

        // 3. Lisätään näppäinkuuntelija undo (Ctrl+Z) ja redo (Ctrl+Y) -toiminnoille
        scene.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.Z) {
                controller.undo();
            } else if (event.isControlDown() && event.getCode() == KeyCode.Y) {
                controller.redo();
            }
        });

        // 4. Määritetään ja näytetään sovelluksen pääikkuna
        primaryStage.setTitle("Memento Pattern - Undo & Redo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
