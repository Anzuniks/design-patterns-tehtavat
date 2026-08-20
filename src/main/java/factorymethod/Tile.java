package factorymethod;



 // Luodaan tile rajapinta/abstrakti luokka, jota kaikki tile-tyypit toteuttavat.
public abstract class Tile {
   //Luodaan getCharacter metodi, joka palauttaa tile-tyypin merkin.
    public abstract char getCharacter();
    //Luodaan getDescription metodi, joka palauttaa tile-tyypin kuvauksen.
    public abstract String getDescription();
    //Luodaan action() metodi, joka suorittaa tile-tyypin toiminnon.
    public abstract void action();

   
}