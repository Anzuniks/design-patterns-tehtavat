package memento;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import java.util.Stack;

public class HistoryWindow {
    private Stage stage;
    private ListView<IMemento> listView;

    public HistoryWindow(Controller controller) {
        listView = new ListView<>();
        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                controller.restoreFromHistory(newVal);
            }
        });
        Scene scene = new Scene(listView, 300, 400);
        stage = new Stage();
        stage.setTitle("History");
        stage.setScene(scene);
    }

    public void show() {
        stage.show();
    }

    public void updateHistory(Stack<IMemento> undoStack) {
        listView.setItems(FXCollections.observableArrayList(undoStack));
    }
}