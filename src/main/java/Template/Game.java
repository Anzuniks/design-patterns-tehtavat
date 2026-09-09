package Template;

/**
 * The framework class. NOT MODIFIED — used exactly as given in the assignment.
 * play() is the "template method": it fixes the skeleton/order of a generic
 * turn-based game and defers the actual game-specific behaviour to the
 * abstract methods that a subclass must implement.
 */

public abstract class Game {

    public final void play(int numberOfPlayers) {

        initializeGame(numberOfPlayers);
        int playerIntTurn = 0;
        while (!endOfGame()) {
            playSingleTurn(playerIntTurn);
            playerIntTurn = ++playerIntTurn % numberOfPlayers;
        }
        displayWinner();
    }

    public abstract void initializeGame(int numberOfPlayers);
    public abstract boolean endOfGame();
    public abstract void playSingleTurn(int playerIntTurn);
    public abstract void displayWinner();

}
