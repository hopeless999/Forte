package piano;

import processing.core.PApplet;
import processing.core.PImage;

public class Cursor extends SingleIconFunction {
    private int velocity;
    
    public Cursor (int x, int y, PImage image) {
        super(x, y, image);
        
        this.velocity = 0; // initially cursor is not moving
    }
    
    public void tick() {
        // Handles logic
        this.x = this.x + this.velocity;
        if (this.x > 528){
            this.x = 48;
        }
    }

    public void draw(PApplet app) {
        // Handling graphics
        app.image(this.image, this.x, this.y);
        // size of cursor image is 24 x 16
        app.line(this.x + 12, this.y + 16, this.x + 12, 335);
        app.stroke(255, 0, 0);
    }

    public boolean move() {
        if(this.velocity == 0){
            this.velocity = 1;
            return true;
        } else {
            this.velocity = 0;
            return false;
        }
    }

    public void reset() {
        this.x = 48;
        this.velocity = 0;
    }

    // returns the x coordinate of the red line
    public int getX() {
        return this.x;
    }

    public int getVelocity() {
        return this.velocity;
    }
}