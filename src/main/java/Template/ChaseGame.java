package Template;

/**
 * ChaseGame — "Pakene vainoojaa" — applies the Game framework to a simple
 * grid chase game.
 *
 * Player 0 = Runner ('R'): tries to survive SURVIVAL_ROUNDS full rounds
 *            without being caught.
 * Player 1 = Chaser ('C'): tries to land on the runner's square before
 *            that many rounds pass.
 *
 * As with TicTacToeGame, Game.play(numberOfPlayers) drives the whole game;
 * this class only fills in the four required steps and keeps all
 * game-specific state (positions, round count) as instance variables.
 */

import java.util.Scanner;

public class ChaseGame extends Game {

    private static final int GRID_SIZE = 6;
    private static final int SURVIVAL_ROUNDS = 10;

    private ChaseBoard board;
    private GridPosition runnerPos;
    private GridPosition chaserPos;
    private Scanner scanner;
    private int roundsCompleted;



    @Override
    public void initializeGame(int numberOfPlayers) {
        if (numberOfPlayers !=  2) {
            throw new IllegalArgumentException("Chase game requires 2 players");

        }
        board = new ChaseBoard(GRID_SIZE);
        runnerPos = new GridPosition(0,0);
        chaserPos = new GridPosition(GRID_SIZE - 1, GRID_SIZE - 1);
        scanner = new Scanner(System.in);
        roundsCompleted = 0;

        System.out.println("=== RUN FROM THE MANIAC ===");
        System.out.println("Player 0 = Runner (R), Player 1 = Chaser");
        System.out.println("Runner survives if not caught within " + SURVIVAL_ROUNDS + " rounds");
        System.out.println("Moves w=up, a=left, d=right, x=stay");

    }
    @Override
    public boolean endOfGame() {
        return runnerPos.sameAs(chaserPos) || roundsCompleted >= SURVIVAL_ROUNDS;
    }

    @Override
    public void playSingleTurn(int playerIntTurn) {
        String roleName = (playerIntTurn == 0) ? "Runner (R)" : "Chaser (C)";
        System.out.println("\n" + roleName + "'s turn." );
        System.out.println("Move (w/a/s/d/x)");
        String input = scanner.next().trim().toLowerCase();

        int deltaRow = 0;
        int deltaCol = 0;
        switch (input) {
            case "w": deltaRow = -1; break;
            case "s": deltaRow = 1; break;
            case "a": deltaCol = -1; break;
            case "d": deltaCol = 1; break;
            case "x": break;
            default:
                System.out.println("Unrecognized move, staying in place");
        }

        if (playerIntTurn == 0) {
            runnerPos = board.clampedMove(runnerPos, deltaRow, deltaCol);
        } else {
            chaserPos = board.clampedMove(chaserPos, deltaRow, deltaCol);

            roundsCompleted++;
        }
        board.print(runnerPos, chaserPos);
    }
    @Override
    public void displayWinner() {
        if (runnerPos.sameAs(chaserPos)) {
            System.out.println("\nCaught! the Chaser wins after " + roundsCompleted + " rounds(s).");

        } else {
            System.out.printf("\nThe Runner survived " + SURVIVAL_ROUNDS + " rounds and wins !");
        }
    }
}
