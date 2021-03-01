package piano;

import processing.core.PImage;

public class MultipleIconsFunction {
    protected int x;
    protected int y;
    protected PImage[] images;
    
    public MultipleIconsFunction(int x, int y, PImage[] images) {
        this.x = x;
        this.y = y;
        this.images = images;
    }

    // public void draw(PApplet app) {
    //     app.image(this.image, this.x, this.y);
    // }
}