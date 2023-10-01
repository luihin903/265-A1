import java.awt.Dimension;

import processing.core.PVector;

public abstract class Util {
    
    public static double random(double a, double b) {
        return Math.random() * (b-a) + a;
    }
    
    public static float random(float a, float b) {
        return (float) (Math.random() * (b-a) + a);
    }

    public static PVector random(Dimension s) {
        float x = random(0, s.width);
        float y = random(0, s.height);
        return new PVector(x, y);
    }
}
