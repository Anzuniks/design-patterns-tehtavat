package factorymethod;

// Luodaan BuildingTile-luokka, joka perii Tile-luokan ja toteuttaa sen metodit.
public class BuildingTile extends Tile {
    
    //Luodaan getCharacter metodi, joka palauttaa tile-tyypin merkin.
    @Override
    public char getCharacter() {
        return 'B';
    }
    
    //Luodaan getDescription metodi, joka palauttaa tile-tyypin kuvauksen.
    @Override
    public String getDescription() {
        return "Building Tile";
    }

    //Luodaan action() metodi, joka suorittaa tile-tyypin toiminnon.
    @Override
    public void action() {
        System.out.println("You have entered a building tile.");
    }

}