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
        double sumX = 0;
        double sumY = 0;
        for (int i = 0; i < polygon.npoints; ++i) {
            sumX += polygon.xpoints[i] ;
            sumY += polygon.ypoints[i] ;
        }

        Point2D.Double center = new Point2D.Double();
        center.x = (double) 1 / polygon.npoints * sumX; //M az osszes atom tomege
        center.y = (double) 1 / polygon.npoints * sumY;
        return center;
    }



    public void draw(Graphics2D g) {
       g.drawPolygon(this.polygonToDraw);
       g.fillPolygon(this.polygonToDraw);



        Point2D.Double centerOfMass = polygonCenterOfMass(this.polygonToDraw);


        if (this.fieldToDraw.getCitizen()!=null){
            g.setColor(Color.black);
            g.fillOval((int) centerOfMass.x, (int) centerOfMass.y, 30,30);
        }

        if(fieldToDraw.getEquipment()!=null){
            g.drawImage(fieldToDraw.getEquipment().getImg(),null, (int)centerOfMass.x,(int)centerOfMass.y);
        }

    }

    public Field getFieldToDraw() {
        return fieldToDraw;
    }

    public Polygon getPolygonToDraw() {
        return polygonToDraw;
    }
}
