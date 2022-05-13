package views;

import map.Field;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public abstract class FieldView implements Drawable{
    protected Field fieldToDraw;
    protected Polygon polygonToDraw;

    public FieldView(Field fieldToDraw, Polygon polygonToDraw) {
        this.fieldToDraw = fieldToDraw;
        this.polygonToDraw = polygonToDraw;
    }

    public Point2D.Double polygonCenterOfMass(Polygon polygon) {
        int N = polygon.npoints;

        double cx = 0, cy = 0;
        //        double A = signedPolygonArea(polygon);
        Point2D.Double res = new Point2D.Double();
        int i, j;
        double sumDet = 0;

        double factor = 0;
        for (i = 0; i < N; i++) {
            j = i + 1;
            factor = (polygon.xpoints[i] * polygon.ypoints[j] - polygon.xpoints[j]
                    * polygon.ypoints[i]);
            cx += (polygon.xpoints[i] + polygon.xpoints[j]) * factor;
            cy += (polygon.ypoints[i] + polygon.ypoints[j]) * factor;

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
        g.drawPolygon(this.polygonToDraw);
        g.fillPolygon(this.polygonToDraw);



        Point2D.Double centerOfMass = polygonCenterOfMass(this.polygonToDraw);


        if (this.fieldToDraw.getCitizen()!=null){
            g.drawOval((int) centerOfMass.x, (int) centerOfMass.y, 100,100);
        }

        if(fieldToDraw.getEquipment()!=null){
            g.drawImage(fieldToDraw.getEquipment().getImg(),null, (int)centerOfMass.x,(int)centerOfMass.y);
        }

    }
}
