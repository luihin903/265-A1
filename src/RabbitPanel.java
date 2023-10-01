import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import processing.core.PVector;

public class RabbitPanel extends JPanel implements ActionListener {
    
    private Rabbit rabbit;
    private Dimension size;
    private Timer t;

    public RabbitPanel(Dimension initialSize) {
        super();

        size = initialSize;

        rabbit = new Rabbit(new PVector(size.width/2, size.height/2), new PVector(100, 100), 1);
        Carrot.init(5, initialSize);
        Tree.init(5, initialSize);

        t = new Timer(33, this);
        t.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        size = getSize();
        setBackground(Color.GRAY);

        Graphics2D g2 = (Graphics2D) g;

        Forest.draw(g2, size);
        rabbit.draw(g2);
        Tree.drawAll(g2);
        Carrot.drawAll(g2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // rabbit.move(Carrot.get());

        repaint();
    }
}
