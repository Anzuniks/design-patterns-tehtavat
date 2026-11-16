package flyweight;

import javafx.scene.canvas.GraphicsContext;

import java.util.Objects;

/**
 * RPG map whose tiles retain only position as extrinsic state.
 */
public final class Map {
    private final int width;
    private final int height;
    private final Tile[][] tiles;
    private final TileGraphicFactory graphicFactory;

    public Map(int width, int height, factorymethod.Map tileFactory) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Map dimensions must be positive");
        }
        this.width = width;
        this.height = height;
        this.graphicFactory = new TileGraphicFactory();
        this.tiles = new Tile[height][width];

        Objects.requireNonNull(tileFactory, "tileFactory");
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                TerrainType type = terrainOf(tileFactory.createTile());
                tiles[row][column] = new Tile(column, row, type,
                        graphicFactory.getGraphic(type));
            }
        }
    }

    private static TerrainType terrainOf(factorymethod.Tile tile) {
        if (tile instanceof factorymethod.ForestTile) {
            return TerrainType.FOREST;
        }
        if (tile instanceof factorymethod.WaterTile) {
            return TerrainType.WATER;
        }
        if (tile instanceof factorymethod.SwampTile) {
            return TerrainType.SWAMP;
        }
        if (tile instanceof factorymethod.RoadTile) {
            return TerrainType.ROAD;
        }
        if (tile instanceof factorymethod.BuildingTile) {
            return TerrainType.BUILDING;
        }
        throw new IllegalArgumentException("Unsupported factory tile: " + tile.getClass());
    }

    public Tile getTile(int column, int row) {
        if (column < 0 || column >= width || row < 0 || row >= height) {
            throw new IndexOutOfBoundsException("Tile outside map: " + column + ", " + row);
        }
        return tiles[row][column];
    }

    public void render(GraphicsContext graphics, double tileSize) {
        Objects.requireNonNull(graphics, "graphics");
        if (tileSize <= 0) {
            throw new IllegalArgumentException("Tile size must be positive");
        }
        for (Tile[] row : tiles) {
            for (Tile tile : row) {
                tile.render(graphics, tileSize);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public TileGraphicFactory getGraphicFactory() {
        return graphicFactory;
    }
}
