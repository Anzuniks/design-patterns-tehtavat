package State;

public class NoviceState implements CharacterState {

    private static final int EXP_TO_ADVANCE = 50;
    private static final int EXP_PER_TRAIN = 15;


    @Override
    public void train(GameCharacter character) {
        character.addExperience(EXP_PER_TRAIN);
        System.out.println(character.getName() + " trains and gains " + EXP_PER_TRAIN + " experience.");

        if (character.getExperience() >= EXP_TO_ADVANCE) {
            character.setState(new IntermediateState());
        }
    }


    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Novices don't know how to meditate. Keep training!");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Novices don't know how to fight. Keep training!");

    }

    @Override
    public String getLevelName() {
        return "Novice";
    }
}
