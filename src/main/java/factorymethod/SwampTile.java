package factorymethod;

// Luodaan ForestTile-luokka, joka perii Tile-luokan ja toteuttaa sen metodit.
public class SwampTile extends Tile {
    //Luodaan getCharacter metodi, joka palauttaa tile-tyypin merkin.
    @Override
    public char getCharacter() {
        return 'S';
    }

    //Luodaan getDescription metodi, joka palauttaa tile-tyypin kuvauksen.
    @Override
    public String getDescription() {
        return "Swamp Tile";
    }

    //Luodaan action() metodi, joka suorittaa tile-tyypin toiminnon.
    @Override
    public void action() {
        System.out.println("You have entered a swamp tile.");
    }
}