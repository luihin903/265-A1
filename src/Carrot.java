import java.awt.Dimension;
import java.awt.Graphics2D;

import processing.core.PVector;

public class Carrot extends Object {
    
    private static Carrot[] carrots;
    private static int capacity;
    private static int size;
    private static final PVector default_dim = new PVector(100, 100);

    public static void init(int maxAmount) {
        capacity = maxAmount;
        carrots = new Carrot[capacity];
        size = 0;
    }

    private Carrot(PVector pos, PVector dim) {
        super(pos, dim);
    }

    private Carrot(Dimension s) {
        super();

        double newX = Util.random(default_dim.x/2, s.width - default_dim.x/2);
        double newY = Util.random(default_dim.y/2, s.height - default_dim.y/2);
        pos = new PVector((float) newX, (float) newY);
        dim = default_dim;
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

    @Override
    public void draw(Graphics2D g) {

    }
}
