import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Arrays;

import processing.core.PVector;

public class Rabbit extends Object {

    private PVector vel;
    private double speed;

    public Rabbit(PVector pos, PVector dim, double speed) {
        super(pos, dim);
        this.speed = speed;
    }

    @Override
    public void draw(Graphics2D g) {
        AffineTransform af = g.getTransform();

        g.translate(pos.x, pos.y);
        g.setColor(Color.WHITE);
        g.fillOval((int) (-dim.x/2), (int) (-dim.y/2), (int) dim.x, (int) dim.y);

        g.setTransform(af);
    }

    public void move(Carrot[] carrots) {
        vel = seek(carrots);
        pos.add(vel);
        System.out.println(Arrays.toString(carrots));
    }

    private PVector seek(Carrot[] carrots) {
        return new PVector();
    }
}
