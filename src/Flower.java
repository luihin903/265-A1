import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import processing.core.PVector;

public class Flower extends Object {
    
    private static Flower[] flowers;
    private static int amount;
    private static PVector default_dim = new PVector(50, 50);

    public static void init(int amount, Dimension s) {
        Flower.amount = amount;
        flowers = new Flower[Flower.amount];

        for (int i = 0; i < Flower.amount; i ++) {
            flowers[i] = new Flower(s);
        }
    }

    private Flower(Dimension s) {
        super();
        pos = Util.random(s);
        dim = default_dim;
    }

    public static void drawAll(Graphics2D g2) {
        for (Flower f : flowers) {
            f.draw(g2);
        }
    }

    @Override
    public void draw(Graphics2D g2) {

        AffineTransform af = g2.getTransform();



        g2.setTransform(af);
    }
}
