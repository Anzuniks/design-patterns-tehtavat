package State;

public class GameCharacter {

    //Rakennettaan pelaajanhahmo
    public static final int MAX_HEALTH = 100;

    public String name;
    public CharacterState state;
    public int experience;
    public int health;

    public GameCharacter(String name) {
        this.name = name;
        this.state = new NoviceState();
        this.experience = 0;
        this.health = MAX_HEALTH;


    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return state.getLevelName();
    }

    public void train() {
        state.train(this);
    }

    public void meditate() {
        state.meditate(this);
    }

    public void fight() {
        state.fight(this);
    }

    public void setState(CharacterState newState) {
        this.state = newState;
        System.out.println(">> " + name + " has advanced to " + newState.getLevelName() + " level!");

    }

    public int getExperience() {
        return experience;
    }

    public void addExperience(int amount) {
        experience += amount;
    }

    public int getHealth() {
        return health;
    }

    public void changeHealth(int amount) {
        health += amount;
        if (health > MAX_HEALTH) {
            health = MAX_HEALTH;
        }
        if (health < 0) {
            health = 0;
        }
    }

    public void printStats() {
        System.out.println("--------------------------------------------");
        System.out.println("Name: " + name);
        System.out.println("Level: " + getLevel());
        System.out.println("Experience: " + experience);
        System.out.println("Health: " + health + "/" +  MAX_HEALTH);
        System.out.println("---------------------------------------------");
    }
}