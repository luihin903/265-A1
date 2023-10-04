import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Arrays;

import processing.core.PVector;

public class Rabbit extends Object {

    private PVector vel;
    private int speed;

    public Rabbit(PVector pos, PVector dim, int speed) {
        super(pos, dim);
        this.speed = speed;
    }

    @Override
    public void draw(Graphics2D g2) {
        drawBoundingBox(g2);
        AffineTransform af = g2.getTransform();

        g2.translate(pos.x, pos.y);
        g2.setColor(Color.WHITE);
        g2.fillOval((int) (-dim.x/2), (int) (-dim.y/2), (int) dim.x, (int) dim.y);

        g2.setTransform(af);
    }

    public void move(Carrot[] carrots) {
        seek(carrots);
        vel.normalize();
        vel.mult(speed);

        pos.add(vel);
        // System.out.println(Arrays.toString(carrots));
    }

    private void seek(Carrot[] carrots) {
        double distance = 9999;

        for (Carrot c : carrots) {
            if (c != null) {
                if (PVector.dist(c.pos, this.pos) < distance) {
                    distance = PVector.dist(c.pos, this.pos);
                    vel = c.pos;
                    vel.sub(this.pos);
                }
            }
        }
    }

    
}
