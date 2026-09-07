package State;

public class MasterState implements CharacterState {

    @Override
    public void train(GameCharacter character) {
        System.out.println("Dont need training");
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Dont need Meditation");

    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Im already the boss");
    }

    @Override
    public String getLevelName() {
        return "Master";
    }


}

