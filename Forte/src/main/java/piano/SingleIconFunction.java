package piano;

import processing.core.PApplet;
import processing.core.PImage;

public class SingleIconFunction {
    protected int x;
    protected int y;
    protected PImage image;
    
    public SingleIconFunction(int x, int y, PImage image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public void draw(PApplet app) {
        app.image(this.image, this.x, this.y);
    }
}