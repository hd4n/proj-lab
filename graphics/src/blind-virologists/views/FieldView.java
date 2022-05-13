package views;

import map.Field;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public abstract class FieldView implements Drawable{
    protected Field fieldToDraw;
    protected ArrayList<Integer> edges;

    public FieldView(Field fieldToDraw, ArrayList<Integer> edges) {
        this.fieldToDraw = fieldToDraw;
        this.edges = edges;
    }

    public Point2D.Double polygonCenterOfMass(Point2D.Double[] polygon) {
        int N = polygon.length - 1;

        double cx = 0, cy = 0;
        //        double A = signedPolygonArea(polygon);
        Point2D.Double res = new Point2D.Double();
        int i, j;
        double sumDet = 0;

        double factor = 0;
        for (i = 0; i < N; i++) {
            j = i + 1;
            factor = (polygon[i].x * polygon[j].y - polygon[j].x
                    * polygon[i].y);
            cx += (polygon[i].x + polygon[j].x) * factor;
            cy += (polygon[i].y + polygon[j].y) * factor;

            sumDet += factor;
        }
        factor = 1 / (3 * sumDet);

        //        A*=6.0;
        //        factor=1/A;
        cx *= factor;
        cy *= factor;
        res.x = cx;
        res.y = cy;
        return res;
    }


    public void draw(Graphics2D g) {
        int size = edges.size();
        ArrayList<Integer> xCoordsList = new ArrayList<>(edges.subList(0,(size)/2));
        ArrayList<Integer> yCoordsList = new ArrayList<>(edges.subList((size)/2, size));

        int[] xCoords = new int[xCoordsList.size()];
        for (int i=0; i < xCoords.length; i++)
        {
            xCoords[i] = xCoordsList.get(i);
        }

        int[] yCoords = new int[yCoordsList.size()];
        for (int i=0; i < yCoords.length; i++)
        {
            yCoords[i] = yCoordsList.get(i);
        }
        Polygon poly = new Polygon(xCoords,yCoords,size/2);
        g.drawPolygon(poly);
        g.fillPolygon(poly);


        Point2D.Double[] polygon=new Point2D.Double[poly.npoints-1];
        for (int i=0; i<xCoords.length-1; i++) {
            polygon[i].x=xCoords[i];
        }

        for (int i=0; i<yCoords.length-1; i++) {
            polygon[i].y=yCoords[i];
        }
        Point2D.Double centerOfMass = polygonCenterOfMass(polygon);


        if (this.fieldToDraw.getCitizen()!=null){
            g.drawOval((int) centerOfMass.x, (int) centerOfMass.y, 1000,1000);
        }

        if(fieldToDraw.getEquipment()!=null){
            g.drawImage(fieldToDraw.getEquipment().getImg(),null, (int)centerOfMass.x,(int)centerOfMass.y);
        }

    }
}
