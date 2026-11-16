package flyweight;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX entry point for the flyweight rendering example.
 */
public final class Game extends Application {
    private static final int COLUMNS = 12;
    private static final int ROWS = 8;
    private static final double TILE_SIZE = 55;

    @Override
    public void start(Stage stage) {
        factorymethod.Map sourceMap = new factorymethod.Game().createMap("wilderness");
        Map map = new Map(COLUMNS, ROWS, sourceMap);

        Canvas canvas = new Canvas(COLUMNS * TILE_SIZE, ROWS * TILE_SIZE);
        map.render(canvas.getGraphicsContext2D(), TILE_SIZE);

        stage.setTitle("Flyweight Rendering for RPG");
        stage.setScene(new Scene(new StackPane(canvas)));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
