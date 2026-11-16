package flyweight;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Shared intrinsic graphic for one terrain type.
 */
public final class TileGraphic {
    private static final Color BORDER_COLOR = Color.web("#263238");
    private final TerrainType terrainType;
    private final Color fillColor;

    TileGraphic(TerrainType terrainType) {
        this.terrainType = terrainType;
        this.fillColor = Color.web(terrainType.getColor());
    }

    public TerrainType getTerrainType() {
        return terrainType;
    }

    public void draw(GraphicsContext graphics, double x, double y, double size) {
        graphics.setFill(fillColor);
        graphics.fillRect(x, y, size, size);

        graphics.setStroke(BORDER_COLOR);
        graphics.strokeRect(x, y, size, size);

        graphics.setFill(Color.WHITE);
        graphics.fillText(String.valueOf(terrainType.getCharacter()),
                x + size * 0.42, y + size * 0.62);
    }
}
