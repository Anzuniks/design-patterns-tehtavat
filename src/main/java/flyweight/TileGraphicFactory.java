package flyweight;

import java.util.EnumMap;
import java.util.Map;

/**
 * Flyweight factory. A terrain graphic is created once and reused thereafter.
 */
public final class TileGraphicFactory {
    private final Map<TerrainType, TileGraphic> graphics = new EnumMap<>(TerrainType.class);

    public TileGraphic getGraphic(TerrainType terrainType) {
        if (terrainType == null) {
            throw new IllegalArgumentException("Terrain type cannot be null");
        }
        return graphics.computeIfAbsent(terrainType, TileGraphic::new);
    }

    public int getCreatedGraphicCount() {
        return graphics.size();
    }
}
