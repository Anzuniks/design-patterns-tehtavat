package flyweight;

/**
 * A tile's intrinsic state. The same value can be shared by every tile of
 * the same terrain type.
 */
public enum TerrainType {
    FOREST('F', "Forest", "#2e7d32"),
    WATER('W', "Water", "#1976d2"),
    SWAMP('S', "Swamp", "#6d4c41"),
    ROAD('R', "Road", "#757575"),
    BUILDING('B', "Building", "#ef6c00");

    private final char character;
    private final String description;
    private final String color;

    TerrainType(char character, String description, String color) {
        this.character = character;
        this.description = description;
        this.color = color;
    }

    public char getCharacter() {
        return character;
    }

    public String getDescription() {
        return description;
    }

    String getColor() {
        return color;
    }
}
