import java.awt.Graphics2D;

import processing.core.PVector;

public class Object {
    
    protected PVector pos, dim;

    public Object(PVector pos, PVector dim) {
        this.pos = pos;
        this.dim = dim;
    }

    public Object() {};

    public void draw(Graphics2D g) {};
}
