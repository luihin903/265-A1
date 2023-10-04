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

    public static PVector random(Dimension s, PVector dim) {
        float x, y;
        
        if ((s.width == 800 && s.height == 600) || (s.width == 1280 && s.height == 720)) {
            x = random(RabbitApp.margin + dim.x/2 + 14, s.width - RabbitApp.margin - dim.x/2 - 14); // my panel is 14px thinner than initial size
            y = random(RabbitApp.margin + dim.y/2 + 37, s.height - RabbitApp.margin - dim.y/2 - 37); // my panel is 37px shorter than initial size
        }
        else {
            x = random(RabbitApp.margin + dim.x/2, s.width - RabbitApp.margin - dim.x/2);
            y = random(RabbitApp.margin + dim.y/2, s.height - RabbitApp.margin - dim.y/2);
        }
        // System.out.printf("Current pos: (%.2f, %.2f), pos limit: (%.2f, %.2f) ~ (%.2f, %.2f)\n", x, y, RabbitApp.margin + dim.x/2, RabbitApp.margin + dim.y/2, s.width - RabbitApp.margin - dim.x/2, s.height - RabbitApp.margin - dim.y/2);
        // System.out.println(s.width);
        return new PVector(x, y);
    }

    public static Color random() {
        return new Color(random(0, 255), random(0, 255), random(0, 255));
    }

    public static Color opposite(Color color) {
        return new Color(255 - color.getRed(), 255 - color.getGreen(), 255 - color.getBlue());
    }
}
