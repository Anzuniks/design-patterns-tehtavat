package State;

public class ExpertState implements CharacterState {

    private static final int EXP_TO_ADVANCE = 200;
    private static final int EXP_PER_TRAIN = 10;
    private static final int HEALTH_PER_MEDITATE = 45;
    private static final int HEALTH_LOST_PER_FIGHT = 20;
    private static final int EXP_PER_FIGHT = 30;




    @Override
    public void train(GameCharacter character) {
        character.addExperience(EXP_PER_TRAIN);
        System.out.println(character.getName() + " trains and gains " + EXP_PER_TRAIN + "experience");

        if (character.getExperience() >= EXP_TO_ADVANCE) {
            character.setState(new MasterState());
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        character.changeHealth(HEALTH_PER_MEDITATE);
        System.out.println(character.getName() + " meditates " + HEALTH_PER_MEDITATE + "health");

    }

    @Override
    public void fight(GameCharacter character) {
        character.changeHealth(-HEALTH_LOST_PER_FIGHT);
        System.out.println("Ouch");
        character.addExperience(EXP_PER_FIGHT);
        System.out.println(character.getName() + " fights " + EXP_PER_FIGHT + "experience");

        if (character.getExperience() >= EXP_TO_ADVANCE) {
            character.setState(new MasterState());
        }
    }

    @Override
    public String getLevelName() {
        return "Expert";
    }


}
