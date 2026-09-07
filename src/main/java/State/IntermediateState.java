package State;

public class IntermediateState implements CharacterState {

    private static final int EXP_TO_ADVANCE = 150;
    private static final int EXP_PER_TRAIN = 15;
    private static final int HEALTH_PER_MEDITATE = 20;

    @Override
    public void train(GameCharacter character) {
        character.addExperience(EXP_PER_TRAIN);
        System.out.println(character.getName() + " trains and gains " + EXP_PER_TRAIN + "experience");

        if  (character.getExperience() >= EXP_TO_ADVANCE) {
            character.setState(new ExpertState());
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        character.changeHealth(HEALTH_PER_MEDITATE);
        System.out.println(character.getName() + " meditates " + HEALTH_PER_MEDITATE + "health");

    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Intermediates are not skilled enough to fight. Keep training and meditating");
    }

    @Override
    public String getLevelName() {
        return "Intermediate";
    }


}
