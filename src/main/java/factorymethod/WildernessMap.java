package factorymethod;

//Sama logiikka kun Citymap-luokassa, mutta tässä tapauksessa kyseessä on WildernessMap-luokka, joka luo metsä- ja tie-tyyppisiä tilejä.


import java.util.Random;

// Luodaan WildernessMap-luokka, joka sisältää kartan ja sen toiminnot.

public class WildernessMap extends Map {

    @Override
    public Tile createTile() {
        // Luodaan satunnnaislukugeneraattori, joka valitsee tile-tyypin satunnaisesti.
        Random random = new Random();

        int luku = random.nextInt(3);

        //Metsässä voi olla vain teitä ja soita. Rakennuksia ei ole sallittu tile-tyyppi metsässä.
        if (luku == 0) {
            return new SwampTile();
        } else if (luku == 1) {
            return new WaterTile();
        } else {
            return new ForestTile();
        }
    }
}