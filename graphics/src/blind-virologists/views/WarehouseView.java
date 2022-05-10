package views;

import map.Field;
import map.Warehouse;

import java.awt.*;
import java.util.ArrayList;

public class WarehouseView extends FieldView{
    Color color=Color.BLUE;

    public WarehouseView(Warehouse fieldToDraw, ArrayList<Integer> edges) {
        super(fieldToDraw, edges);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        super.draw(g);
    }
}
