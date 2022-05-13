package main;


import views.MapGenerator;

import citizens.Citizen;
import citizens.Virologist;
import effects.*;
import items.*;
import map.*;
import views.EmptyView;
import views.FieldView;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Main extends JFrame {

    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;

    private static MapGenerator mapGenerator = new MapGenerator();

    public Main() {
        super("alma");
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    //a paint (vagy paintComponent) overrideolasaval kapod meg a komponens Grapics-et
    @Override
    public void paint(Graphics g) {
        ArrayList<Integer> edges = new ArrayList<>();
        edges.add(30);
        edges.add(70);
        edges.add(900);
        edges.add(300);
        edges.add(350);
        edges.add(40);
        edges.add(50);
        edges.add(200);
        Virologist v=new Virologist();
        Empty empty = new Empty();
        empty.setCitizen(v);
        EmptyView ev = new EmptyView(empty,edges);
        Graphics2D g2d = (Graphics2D) g;

        //draw(g2d);

        mapGenerator.drawPolygons(g2d);
        var originalStroke = g2d.getStroke();
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(20));
        g2d.drawRect(MapGenerator.BASE_OFFSET_X + 5, MapGenerator.BASE_OFFSET_Y, MapGenerator.MAP_WIDTH_PX, MapGenerator.MAP_HEIGHT_PX);
        g2d.setStroke(originalStroke);
    }

    private static Polygon polygon;
    private static Polygon polygon1;
    private static Polygon polygon2;

    private boolean gen = false;

    public void draw(Graphics2D g) {

        ev.draw(g2d);

    }

    /*public void draw(Graphics2D g) {

        g.drawRect(50, 50, 50, 50);
    }*/



    public static void main(String[] args) {
        Main m = new Main();
        m.pack();
        m.setVisible(true);
        polygon = mapGenerator.createLowerPolygon(100, 100);

        int[] xCoords = {0, 150, 150, 0};
        int[] yCoords = {0, 0, 150, 150};

        //polygon1=new Polygon(xCoords,yCoords,4);
        //polygon1=new Polygon(new int[]{-10,400,400,-10},new int[]{0,0,400,400},4);
        //polygon1=new Polygon(new int[]{100,170,170,100},new int[]{100,100,170,170},4);
        polygon1 = mapGenerator.createUpperPolygon(0, 35);
        polygon2 = mapGenerator.createUpperPolygon(100, 170);

        m.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                for (var p : mapGenerator.getUpperLayer()) {
                    if (p.contains(e.getPoint())) {
                        System.out.println("upper");
                        return;
                    }
                }

                for (var p : mapGenerator.getLowerLayer()) {
                    if (p.contains(e.getPoint())) {
                        System.out.println("lower");
                        return;
                    }
                }
            }
        });

        m.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == 'r') {
                    mapGenerator.generateAllPolygons();
                    m.repaint();
                }
            }
        });

        mapGenerator.generateAllPolygons();
        m.gen = true;

        m.repaint();
    }
}