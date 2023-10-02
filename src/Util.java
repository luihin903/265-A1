import java.awt.Color;
import java.awt.Dimension;

import processing.core.PVector;

public abstract class Util {
    
    public static double random(double a, double b) {
        return Math.random() * (b-a) + a;
    }
    
    public static float random(float a, float b) {
        return (float) (Math.random() * (b-a) + a);
    }

    public static int random(int a, int b) {
        return (int) random((double) a, (double) b);
    }

    public static PVector random(Dimension s) {
        float x = random(0, s.width);
        float y = random(0, s.height);
        return new PVector(x, y);
    }

    public static Color random() {
        return new Color(random(0, 255), random(0, 255), random(0, 255));
    }

    public static Color opposite(Color color) {
        return new Color(255 - color.getRed(), 255 - color.getGreen(), 255 - color.getBlue());
    }
}
