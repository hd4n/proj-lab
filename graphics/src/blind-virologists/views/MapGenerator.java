package views;

import map.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/*
    ------->X
    |
    |
    |
    V
    Y
 */


public class MapGenerator {

    public static class Coordinates {
        public int x, y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * alap palya eltolas
     */
    public static final int BASE_OFFSET_X = 30;
    public static final int BASE_OFFSET_Y = 11;

    /**
     * uj csucspontok maximalis eltolasa
     */
    public static final int MAX_VERTEX_SHIFT_X = 10;
    public static final int MAX_VERTEX_SHIFT_Y = 10;

    /**
     * egy mezo merete
     */
    public static final int TILE_SIZE_PX = 110;

    /**
     * mezok szama
     */
    public static final int MAP_SIZE_X = 9;
    public static final int MAP_SIZE_Y = 5;

    /**
     * palya meret pixelben
     */
    public static final int MAP_WIDTH_PX = MAP_SIZE_X * TILE_SIZE_PX;
    public static final int MAP_HEIGHT_PX = MAP_SIZE_Y * TILE_SIZE_PX;

    private ArrayList<Polygon> lowerLayer = new ArrayList<>();
    private ArrayList<Polygon> upperLayer = new ArrayList<>();

    public ArrayList<Drawable> getFieldViews() {
        return fieldViews;
    }

    private ArrayList<Drawable> fieldViews = new ArrayList<>();

    /**
     * Generates the map,
     * puts the created fields into fieldViews
     */
    public void generateMap() {
        //generate all tiles
        generateAllPolygons();

        Random r = new Random();
        int a = 0;
        int b = 0;
        for (int i = 0; i < MAP_SIZE_Y; i++) {
            for (int j = 0; j < MAP_SIZE_X; j++) {
                Polygon polygon;
                if ((i * MAP_SIZE_Y + j) % 2 == 0) {
                    polygon = lowerLayer.get(a);
                    a++;
                } else {
                    polygon = upperLayer.get(b);
                    b++;
                }

                int nextTileType = r.nextInt(7);
                switch (nextTileType) {
                    case 0://Shelter
                        Shelter shelter = new Shelter();
                        ShelterView shelterView = new ShelterView(shelter, polygon);
                        fieldViews.add(shelterView);
                        break;
                    case 1://Warehouse
                        Warehouse warehouse = new Warehouse();
                        WarehouseView warehouseView = new WarehouseView(warehouse, polygon);
                        fieldViews.add(warehouseView);
                        break;
                    case 2://Laboratory
                        Laboratory laboratory = new Laboratory();
                        LaboratoryView laboratoryView = new LaboratoryView(laboratory, polygon);
                        fieldViews.add(laboratoryView);
                        break;
                    case 3://InfectedLaboratory
                        InfectedLaboratory infectedLaboratory = new InfectedLaboratory();
                        InfectedLaboratoryView infectedLaboratoryView = new InfectedLaboratoryView(infectedLaboratory, polygon);
                        fieldViews.add(infectedLaboratoryView);
                        break;

                    default://Empty
                        Empty empty = new Empty();
                        EmptyView emptyView = new EmptyView(empty, polygon);
                        fieldViews.add(emptyView);
                        break;
                }
            }
        }

    }

    /**
     * uj kereszt alaku poligon keszitese nagyobb merettel, csucsok randomizalasa nelkul
     *
     * @param x koordinata
     * @param y koordinata
     * @return uj poligon
     */
    public Polygon createLowerPolygon(int x, int y) {
        int[] xCoords = new int[]{x, x, x + TILE_SIZE_PX, x + TILE_SIZE_PX, x + TILE_SIZE_PX + MAX_VERTEX_SHIFT_X, x + TILE_SIZE_PX + MAX_VERTEX_SHIFT_X, x + TILE_SIZE_PX, x + TILE_SIZE_PX, x, x, x - MAX_VERTEX_SHIFT_X, x - MAX_VERTEX_SHIFT_X};
        int[] yCoords = new int[]{y, y - MAX_VERTEX_SHIFT_Y, y - MAX_VERTEX_SHIFT_Y, y, y, y + TILE_SIZE_PX, y + TILE_SIZE_PX, y + TILE_SIZE_PX + MAX_VERTEX_SHIFT_Y, y + TILE_SIZE_PX + MAX_VERTEX_SHIFT_Y, y + TILE_SIZE_PX, y + TILE_SIZE_PX, y};
        return new Polygon(xCoords, yCoords, 12);
    }

    /**
     * uj poligon keszitese normal merettel, csucsok randomizalasaval
     *
     * @param x koordinata
     * @param y koordinata
     * @return uj poligon
     */
    public Polygon createUpperPolygon(int x, int y) {
        int[] xCoords = {x, x + TILE_SIZE_PX, x + TILE_SIZE_PX, x};
        int[] yCoords = {y, y, y + TILE_SIZE_PX, y + TILE_SIZE_PX};
        Polygon polygon = new Polygon(xCoords, yCoords, 4);
        var coords = generateVertices(polygon);

        return new Polygon(getXCoordinates(coords), getYCoordinates(coords), coords.size());
    }

    /**
     * a palya osszes poligonjanak legeneralasa
     */
    public void generateAllPolygons() {
        lowerLayer.clear();
        upperLayer.clear();
        for (int y = 0; y < MAP_SIZE_Y; y++) {
            int tmp = y % 2 == 0 ? 0 : 1;
            for (int x = 0; x < MAP_SIZE_X; x++) {
                if (tmp % 2 == 0) {
                    lowerLayer.add(createLowerPolygon(BASE_OFFSET_X + x * TILE_SIZE_PX, BASE_OFFSET_Y + y * TILE_SIZE_PX));
                } else {
                    upperLayer.add(createUpperPolygon(BASE_OFFSET_X + x * TILE_SIZE_PX, BASE_OFFSET_Y + y * TILE_SIZE_PX));
                }
                tmp++;

            }
        }
    }

    /**
     * az osszes poligon felrajzolasa
     *
     * @param g a cel Graphics2D
     */
    public void drawPolygons(Graphics2D g) {


        for (int i = 0; i < fieldViews.size(); i += 2) {
            fieldViews.get(i).draw(g);
        }
        for (int i = 1; i < fieldViews.size(); i += 2) {
            fieldViews.get(i).draw(g);
            g.setColor(Color.BLACK);
            var stroke = g.getStroke();
            g.setStroke(new BasicStroke(2));
            g.drawPolygon(fieldViews.get(i).getPolygonToDraw());
            g.setStroke(stroke);
        }

        var originalStroke = g.getStroke();
        g.setColor(Color.WHITE);
        g.setStroke(new BasicStroke(25));
        g.drawRect(MapGenerator.BASE_OFFSET_X - 4, MapGenerator.BASE_OFFSET_Y, MapGenerator.MAP_WIDTH_PX + 2, MapGenerator.MAP_HEIGHT_PX);
        g.setStroke(originalStroke);
    }

    /**
     * uj random poligon generalasa a meglevo alapjan, az eredeti oldalain uj csucsok felvetelevel es eltolassukkal
     *
     * @param p az uj poligon alapja
     * @return uj poligon
     */
    private ArrayList<Coordinates> generateVertices(Polygon p) {
        Random random = new Random();

        ArrayList<Coordinates> polyCoords = getPolyCoordinates(p);

        ArrayList<Coordinates> newCoords = new ArrayList<>();

        for (int i = 0; i < polyCoords.size(); i++) {
            Coordinates edgeBegin = polyCoords.get(i);
            Coordinates edgeEnd;
            if (i + 1 == polyCoords.size()) {
                edgeEnd = polyCoords.get(0);
            } else {
                edgeEnd = polyCoords.get(i + 1);
            }

            newCoords.add(edgeBegin);

            //oldal kihagyasa ha a az palya szele
            if ((edgeBegin.x == BASE_OFFSET_X && edgeEnd.x == BASE_OFFSET_X)
                    || (edgeBegin.x == BASE_OFFSET_X + MAP_WIDTH_PX && edgeEnd.x == BASE_OFFSET_X + MAP_WIDTH_PX)
                    || (edgeBegin.y == BASE_OFFSET_Y && edgeEnd.y == BASE_OFFSET_Y)
                    || (edgeBegin.y == BASE_OFFSET_Y + MAP_HEIGHT_PX && edgeEnd.y == BASE_OFFSET_Y + MAP_HEIGHT_PX)) {
                continue;
            }

            int addEdge = random.nextInt(3);
            if (addEdge == 0) {
                continue;
            }

            int _offsetX = random.nextInt(2 * MAX_VERTEX_SHIFT_X) - MAX_VERTEX_SHIFT_X;
            int _offsetY = random.nextInt(2 * MAX_VERTEX_SHIFT_Y) - MAX_VERTEX_SHIFT_Y;

            int newX = (edgeEnd.x - edgeBegin.x) / 2 + edgeBegin.x;
            int newY = (edgeEnd.y - edgeBegin.y) / 2 + edgeBegin.y;

            newX += _offsetX;
            newY += _offsetY;

            newCoords.add(new Coordinates(newX, newY));
        }
        return newCoords;
    }

    /**
     * poligon koordinatainak visszaadasa Coordinates listakent
     *
     * @param p poligon
     * @return lista a koordinatakkal
     */
    public static ArrayList<Coordinates> getPolyCoordinates(Polygon p) {
        ArrayList<Coordinates> out = new ArrayList<>();

        int[] xPoints = p.xpoints;
        int[] yPoints = p.ypoints;

        for (int i = 0; i < xPoints.length; i++) {
            out.add(new Coordinates(xPoints[i], yPoints[i]));
        }

        return out;
    }

    /**
     * Coordinates listabol az x koordinatak kivalogatasa es tombkent visszaadasa a poligon keszitesehez
     *
     * @param coords bemeneti lista
     * @return tomb az x koordinatakbol
     */
    public static int[] getXCoordinates(ArrayList<Coordinates> coords) {
        ArrayList<Integer> outCoords = new ArrayList<>();
        for (int i = 0; i < coords.size(); i++) {
            outCoords.add(coords.get(i).x);
        }
        return outCoords.stream().mapToInt(i -> i).toArray();
    }

    /**
     * Coordinates listabol az y koordinatak kivalogatasa es tombkent visszaadasa a poligon keszitesehez
     *
     * @param coords bemeneti lista
     * @return tomb az y koordinatakbol
     */
    public static int[] getYCoordinates(ArrayList<Coordinates> coords) {
        ArrayList<Integer> outCoords = new ArrayList<>();
        for (int i = 0; i < coords.size(); i++) {
            outCoords.add(coords.get(i).y);
        }
        return outCoords.stream().mapToInt(i -> i).toArray();
    }

    public ArrayList<Polygon> getLowerLayer() {
        return lowerLayer;
    }

    public ArrayList<Polygon> getUpperLayer() {
        return upperLayer;
    }
}
