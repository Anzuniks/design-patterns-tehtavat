package factorymethod;

//Toistetaan RoadTile-luokka, joka perii Tile-luokan ja toteuttaa sen metodit. Sama periaate kuin BuildingTile- ja ForestTile-luokissa, mutta tässä tapauksessa kyseessä on tie-tyyppinen tile.
public class RoadTile extends Tile {

    //Luodaan getCharacter metodi, joka palauttaa tile-tyypin merkin.
    @Override
    public char getCharacter() {
        return 'R';
    }

    //Luodaan getDescription metodi, joka palauttaa tile-tyypin kuvauksen.
    @Override
    public String getDescription() {
        return "Road Tile";
    }

    //Luodaan action() metodi, joka suorittaa tile-tyypin toiminnon.
    @Override
    public void action() {
        System.out.println("You have entered a road tile.");
    }

}
