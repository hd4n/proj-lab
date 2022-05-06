package main;

import citizens.Citizen;
import citizens.Virologist;
import effects.*;
import items.*;
import map.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;


public class Main extends JFrame {

    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;

    public Main() {
        super("alma");
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    //a paint (vagy paintComponent) overrideolasaval kapod meg a komponens Grapics-et
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        draw(g2d);
    }

    public void draw(Graphics2D g) {
        g.drawRect(50, 50, 50, 50);
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.pack();
        m.setVisible(true);
    }
}