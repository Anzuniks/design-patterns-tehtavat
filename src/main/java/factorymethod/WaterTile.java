package factorymethod;


// Luodaan WaterTile-luokka, joka perii Tile-luokan ja toteuttaa sen metodit.
public class WaterTile extends Tile {
    
    //Luodaan getCharacter metodi, joka palauttaa tile-tyypin merkin.
    @Override
    public char getCharacter() {
        return 'W';
    }

    //Luodaan getDescription metodi, joka palauttaa tile-tyypin kuvauksen.
    @Override
    public String getDescription() {
        return "Water Tile";
    }

    //Luodaan action() metodi, joka suorittaa tile-tyypin toiminnon.
    @Override
    public void action() {
        System.out.println("You have entered a water tile.");
    }
}