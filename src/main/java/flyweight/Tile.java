package flyweight;

import javafx.scene.canvas.GraphicsContext;

import java.util.Objects;

/**
 * A tile contains extrinsic position and a reference to shared intrinsic
 * terrain graphics.
 */
public final class Tile {
    private final int column;
    private final int row;
    private final TerrainType terrainType;
    private final TileGraphic graphic;

    Tile(int column, int row, TerrainType terrainType, TileGraphic graphic) {
        this.column = column;
        this.row = row;
        this.terrainType = Objects.requireNonNull(terrainType);
        this.graphic = Objects.requireNonNull(graphic);
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public TerrainType getTerrainType() {
        return terrainType;
    }

    public char getCharacter() {
        return terrainType.getCharacter();
    }

    public String getDescription() {
        return terrainType.getDescription();
    }

    public TileGraphic getGraphic() {
        return graphic;
    }

    public void render(GraphicsContext graphics, double tileSize) {
        graphic.draw(graphics, column * tileSize, row * tileSize, tileSize);
    }

    public void action() {
        System.out.println("You have entered a " + terrainType.getDescription().toLowerCase()
                + " tile at (" + column + ", " + row + ").");
    }
}
