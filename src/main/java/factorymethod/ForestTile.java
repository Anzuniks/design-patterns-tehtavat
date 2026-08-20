package factorymethod;

// Luodaan ForestTile-luokka, joka perii Tile-luokan ja toteuttaa sen metodit. Sama periaate kuin BuildingTile-luokassa, mutta tässä tapauksessa kyseessä on metsä-tyyppinen tile.
public class ForestTile extends Tile {

    //Luodaan getCharacter metodi, joka palauttaa tile-tyypin merkin. @Override tekee metodin ylikirjoittamisen Tile-luokasta, jotta ForestTile-luokka voi määritellä oman merkkinsä.
    @Override
    public char getCharacter() {
        return 'F';
    }

    //Luodaan getDescription metodi, joka palauttaa tile-tyypin kuvauksen.
    @Override
    public String getDescription() {
        return "Forest Tile";
    }

    //Luodaan action() metodi, joka suorittaa tile-tyypin toiminnon.
    @Override
    public void action() {
        System.out.println("You have entered a forest tile.");
    }

}
