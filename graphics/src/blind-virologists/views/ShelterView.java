package views;

import map.Field;
import map.Shelter;

import java.awt.*;
import java.util.ArrayList;

public class ShelterView extends FieldView{
    Color color=Color.PINK;

    public ShelterView(Shelter fieldToDraw, ArrayList<Integer> edges) {
        super(fieldToDraw, edges);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        super.draw(g);
    }
}
