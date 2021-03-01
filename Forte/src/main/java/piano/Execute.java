package piano;

import processing.core.PImage;
import processing.core.PApplet;

public class Execute extends MultipleIconsFunction {
    private PImage currButton;
    
    public Execute(int x, int y, PImage[] images) {
        super(x, y, images);
        this.currButton = images[0]; // default showing play button
    }

    public void draw(PApplet app) {
        // Handling graphics
        app.image(this.currButton, this.x, this.y);
    }

    public void update() {
        try {
            if(this.currButton.equals(this.images[0])) {
                this.currButton = this.images[1];
            } else {
                this.currButton = this.images[0];
            }
        } catch (NullPointerException e) {
            this.currButton = null;
        }
    }

    public void reset() {
        this.currButton = this.images[0];
    }

    public PImage getCurr() { // for testing only
        return this.currButton;
    }
}