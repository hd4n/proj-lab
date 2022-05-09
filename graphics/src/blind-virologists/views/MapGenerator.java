package views;

import map.Empty;
import map.Field;

import javax.swing.text.FieldView;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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

    public class Coordinates {
        public int x, y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static final int offsetX = 100;
    public static final int offsetY = 100;

    public static final int MAX_VERTEX_SHIFT_X = 10;
    public static final int MAX_VERTEX_SHIFT_Y = 10;
    public static final int MAX_NEW_VERTICES = 3;
    public static final int TILE_SIZE_PX = 70;
    public static final int MAP_SIZE_X = 7;
    public static final int MAP_SIZE_Y = 5;

    public void generateMap(Graphics2D g) {
        //generate all tiles
        Random r = new Random();

        ArrayList<FieldView> fieldViews = new ArrayList<>();
        for (int i = 0; i < MAP_SIZE_Y; i++){
            for (int j = 0; j < MAP_SIZE_X; j++){
                int[] xCoords = {j*TILE_SIZE_PX, (j+1)*TILE_SIZE_PX, (j+1)*TILE_SIZE_PX, j*TILE_SIZE_PX};
                int[] yCoords = {i*TILE_SIZE_PX, i*TILE_SIZE_PX, (i+1)*TILE_SIZE_PX, (i+1)*TILE_SIZE_PX};
                for (int k = 0; k < xCoords.length; k++) {
                    xCoords[k] += offsetX;
                    yCoords[k] += offsetY;
                }

                int nextTileType = r.nextInt(5);
                switch (nextTileType) {
                    case 0://Empty
                        Empty empty = new Empty();
                        //EmptyView emptyView = new EmptyView();
                        break;
                    case 1://Shelter
                        break;
                    case 2://Warehouse
                        break;
                    case 3://Laboratory
                        break;
                    case 4://InfectedLaboratory
                        break;
                }
            }
        }


        //for... add vertices
        int[] xCoords = {0, TILE_SIZE_PX, TILE_SIZE_PX, 0};
        int[] yCoords = {0, 0, TILE_SIZE_PX, TILE_SIZE_PX};
        for (int k = 0; k < xCoords.length; k++) {
            xCoords[k] += offsetX;
            yCoords[k] += offsetY;
        }

        int[] xCoordsProba = {100,135,170,174,170,142,100};
        int[] yCoordsProba = {100,102,100,138,170,175,170};
        Polygon proba = new Polygon(xCoordsProba, yCoordsProba, 7);

        Polygon p = new Polygon(xCoords, yCoords, 4);

        var c = generateVertices(p);

        Polygon pnew=new Polygon(getXCoordinates(c),getYCoordinates(c),c.size());

        g.drawPolygon(proba);
    }


    private ArrayList<Coordinates> generateVertices(Polygon p) {
        Random random = new Random();

        ArrayList<Coordinates> polyCoords = getPolyCoordinates(p);

        ArrayList<Coordinates> newCoords = new ArrayList<>();

        for (int i = 0; i < polyCoords.size() - 1; i++) {
            Coordinates edgeBegin = polyCoords.get(i);
            Coordinates edgeEnd = polyCoords.get(i + 1);

            int newVertCount = random.nextInt(MAX_NEW_VERTICES);

            //todo negatives
            int _offsetX = random.nextInt(MAX_VERTEX_SHIFT_X);
            int _offsetY = random.nextInt(MAX_VERTEX_SHIFT_Y);

            int newX = (edgeEnd.x - edgeBegin.x) / 2 + edgeBegin.x;
            int newY = (edgeEnd.y - edgeBegin.y) / 2 + edgeBegin.y;
            newX += _offsetX;
            newY += _offsetY;

            newCoords.add(edgeBegin);
            newCoords.add(new Coordinates(newX, newY));

        }
        newCoords.add(polyCoords.get(polyCoords.size()-1));
        return newCoords;
    }

    private int getSide() {
        return -1;
    }

    private ArrayList<Coordinates> getPolyCoordinates(Polygon p) {

        ArrayList<Coordinates> out = new ArrayList<>();

        int[] xPoints = p.xpoints;
        int[] yPoints = p.ypoints;

        for (int i = 0; i < xPoints.length; i++) {
            out.add(new Coordinates(xPoints[i], yPoints[i]));
        }

        return out;
    }

    private int[] getXCoordinates(ArrayList<Coordinates> coords){
        ArrayList<Integer> outCoords=new ArrayList<>();
        for (int i = 0; i < coords.size(); i++) {
            outCoords.add(coords.get(i).x);
        }
        return outCoords.stream().mapToInt(i->i).toArray();
    }

    private int[] getYCoordinates(ArrayList<Coordinates> coords){
        ArrayList<Integer> outCoords=new ArrayList<>();
        for (int i = 0; i < coords.size(); i++) {
            outCoords.add(coords.get(i).y);
        }
        return outCoords.stream().mapToInt(i->i).toArray();
    }
}
