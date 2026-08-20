//Luodaaan kartta joka perii tile-luokan ja toteuttaa sen metodit.
package factorymethod;

public  abstract class Map {
        // 1. Factory Method: Pakottaa alaluokat määrittelemään ruutujen luomislogiika
        public abstract Tile createTile();

        //2. Metodi, joka luon kartan piirustuksen ja testaa tile-tyyppejä.
        public void display() {
            int width = 5;
            int height = 5;

            // Luodaan 2D-taulukko, joka sisältää tile-tyypit.
            Tile[][] map = new Tile[height][width];
            
            // Luodaan kartta, jossa on erilaisia tile-tyyppejä.
            //Luodaan for-silmukka, joka käy läpi kartan ruudut ja luo tile-tyypit.
            for (int i = 0; i < height; i++) {

                //Sisempi for-silmukka, joka käy läpi kartan ruudut ja luo tile-tyypit.
                for (int j = 0; j < width; j++) {

                    //Tilataan tehtaalta yksi ruutu
                    Tile tile = createTile();

                    // Tulostetaan ruudun kirjain ja välilyönti (huom: print, ei println)
                    System.out.print(tile.getCharacter() + " "); 
                }
                System.out.println(); // Tulostetaan rivinvaihto jokaisen rivin jälkeen
            }
 
        }
}