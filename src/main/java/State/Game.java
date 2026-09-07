package State;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("What is your player name");
        String playerName = input.nextLine();

        GameCharacter character = new GameCharacter(playerName);

        while (!character.getLevel().equals("Master")) {
            character.printStats();

            System.out.println("What do you want to do? (train / meditate / fight)");
            String choice = input.nextLine();

            if (choice.equals("train")) {
                character.train();
            } else if (choice.equals("meditate")) {
                character.meditate();
            } else if (choice.equals("fight")) {
                character.fight();
            } else {
                System.out.println("Unknown action, try again.");
            }
        }

        character.printStats();
        System.out.println(character.getName() + " has reached Master level! The game is over.");
    }
}