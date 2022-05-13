package views;

import map.Empty;
import map.Field;

import java.awt.*;
import java.util.ArrayList;

public class EmptyView extends FieldView{
    Color color= Color.GREEN;

    public EmptyView(Empty fieldToDraw, ArrayList<Integer> edges) {
        super(fieldToDraw, edges);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        super.draw(g);
    }
}
