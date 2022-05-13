package views;

import map.Field;
import map.InfectedLaboratory;

import java.awt.*;
import java.util.ArrayList;

public class InfectedLaboratoryView extends FieldView{
    Color color= Color.RED;

    public InfectedLaboratoryView(InfectedLaboratory fieldToDraw, ArrayList<Integer> edges) {
        super(fieldToDraw, edges);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        super.draw(g);
    }
}
