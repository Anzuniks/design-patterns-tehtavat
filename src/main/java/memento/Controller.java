package memento;

import java.util.Stack;

public class Controller {
    private Stack<IMemento> undoStack = new Stack<>();
    private Stack<IMemento> redoStack = new Stack<>();

    private Model model;
    private Gui gui; // Lisätty Gui-muuttuja
    private HistoryWindow historyWindow;

    public Controller(Model model) {
        this.model = model;
        this.historyWindow = new HistoryWindow(this);
        this.historyWindow.show();
    }

    // Lisätty metodi Modelin hakemiseen Gui-luokkaa varten
    public Model getModel() {
        return model;
    }

    // Lisätty metodi Gui:n asettamiseen
    public void setGui(Gui gui) {
        this.gui = gui;
    }

    public void saveState() {
        undoStack.push(model.createMemento());
        redoStack.clear();
        historyWindow.updateHistory(undoStack);
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(model.createMemento());
            IMemento memento = undoStack.pop();
            model.restoreState(memento);
            historyWindow.updateHistory(undoStack);

            // Päivitetään käyttöliittymä ruudulla
            if (gui != null) gui.update();
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(model.createMemento());
            IMemento memento = redoStack.pop();
            model.restoreState(memento);
            historyWindow.updateHistory(undoStack);

            // Päivitetään käyttöliittymä ruudulla
            if (gui != null) gui.update();
        }
    }

    public void restoreFromHistory(IMemento memento) {
        model.restoreState(memento);

        // Päivitetään käyttöliittymä ruudulla
        if (gui != null) gui.update();
    }
}
