import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

public abstract class Forest {

    private static int margin = 20;

    public static void draw(Graphics2D g2, Dimension s) {
        
        g2.setColor(Color.GREEN);
        g2.fillRect(margin, margin, s.width - margin*2, s.height - margin*2);
        
    }

}
