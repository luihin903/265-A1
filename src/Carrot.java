import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import processing.core.PVector;

public class Carrot extends Object {
    
    private static Carrot[] carrots;
    private static int capacity;
    private static int size;
    private static final PVector default_dim = new PVector(100, 100);

    public static void init(int maxAmount, Dimension s) {
        capacity = maxAmount;
        size = 0;
        carrots = new Carrot[capacity];
        
        for (int i = 0; i < capacity; i ++) {
            spawn(s);
        }
    }

    private Carrot(PVector pos, PVector dim) {
        super(pos, dim);

        size ++;
    }

    private Carrot(Dimension s) {
        super();

        pos = Util.random(s);
        dim = default_dim;

        size ++;
    }

    public static void spawn(Dimension s) {
        if (size < capacity) {
            for (int i = 0; i < carrots.length; i ++) {
                if (carrots[i] == null) {
                    carrots[i] = new Carrot(s);
                    break;
                }
            }
        }
    }

    public static Carrot[] get() {
        return carrots;
    }

    public static void drawAll(Graphics2D g2) {
        for (Carrot c : carrots) {
            if (c != null) {
                c.draw(g2);
            }
        }
    }

    @Override
    public void draw(Graphics2D g2) {

        drawBoundingBox(g2);
        AffineTransform af = g2.getTransform();

        g2.translate(pos.x, pos.y);
        g2.setColor(Color.ORANGE);
        g2.fillOval((int) (-dim.x/4), 0, (int) (dim.x/2), (int) (dim.y/4));
        int[] xPoints = {(int) (-dim.x/4), 0, (int) (dim.x/4)};
        int[] yPoints = {(int) (-dim.y/8*3), (int) (dim.y), (int) (-dim.y/8*3)};
        g2.fillPolygon(xPoints, yPoints, 3);

        g2.setTransform(af);
    }
}
