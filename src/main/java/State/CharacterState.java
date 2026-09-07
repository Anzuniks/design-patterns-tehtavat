package State;


public interface CharacterState {

    //Lets build the character state
    void train(GameCharacter character);
    void meditate(GameCharacter character);
    void fight(GameCharacter character);

    String getLevelName();

}
