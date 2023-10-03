import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import processing.core.PVector;

public class Flower extends Object {
    
    private static Flower[] flowers;
    private static int amount;
    private static final PVector default_dim = new PVector(100, 100);
    private Color color;

    public static void init(int amount, Dimension s) {
        Flower.amount = amount;
        flowers = new Flower[Flower.amount];

        for (int i = 0; i < Flower.amount; i ++) {
            flowers[i] = new Flower(s);
        }
    }

    private Flower(Dimension s) {
        super(s);
        pos = Util.random(s);
        dim = default_dim;
        color = Util.random();
    }

    public static void drawAll(Graphics2D g2) {
        for (Flower f : flowers) {
            f.draw(g2);
        }
    }

    @Override
    public void draw(Graphics2D g2) {

        drawBoundingBox(g2);

        AffineTransform af = g2.getTransform();
        g2.translate(pos.x, pos.y);

        g2.setColor(Color.BLACK);
        g2.drawArc(0, 0, (int) (dim.x/2), (int) (dim.y), 120, 60);

        AffineTransform af2 = g2.getTransform();
        g2.translate((int) (dim.x/8), (int) (dim.y/8));

        g2.setColor(color);
        for (int i = 0; i < 8; i ++) {
            g2.fillArc((int) (-dim.x/32), (int) (-dim.y/8), (int) (dim.x/16), (int) (dim.y/8), -45, 270);
            g2.rotate(Math.toRadians(45));
        }

        g2.setColor(Util.opposite(color));
        g2.fillOval((int) (-dim.x/16), (int) (-dim.y/16), (int) (dim.x/8), (int) (dim.y/8));


        g2.setTransform(af2);
        g2.setTransform(af);
    }
}
