package factorymethod;

public class Game {

    // Pääohjelma alkaa
    public static void main(String[] args) {
        Game game = new Game();

        // 1. Luodaan kartta (kokeillaan vaihtaa tähän myöhemmin "wilderness")
        Map myMap = game.createMap("city");

        // 2. Tulostetaan kartta
        System.out.println("Map:");
        myMap.display();
    } // <-- TÄMÄ aaltosulje sulkee main-metodin!

    // Factory Method alkaa
    public Map createMap(String mapType) {
        // Logiikka: luodaan joko kaupunki (city) tai erämaa (wilderness)
        if (mapType.equalsIgnoreCase("city")) {
            return new CityMap();
        } else if (mapType.equalsIgnoreCase("wilderness")) {
            return new WildernessMap();
        } else {
            // IllegalArgumentException heitetään, jos mapType ei ole tunnistettu.
            throw new IllegalArgumentException("Invalid map type: " + mapType);
        }
    }
}