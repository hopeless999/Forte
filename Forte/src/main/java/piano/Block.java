package piano;

import processing.core.PImage;
import processing.core.PApplet;

public class Block extends SingleIconFunction {
    private boolean active;
    private Sound sound;
    
    public Block (int x, int y, PImage image, Sound sound) {
        super(x, y, image);
        this.active = false;
        this.sound = sound;
    }

    public void draw(PApplet app) {
        // Handling graphics
        if(this.active) {
            app.image(this.image, this.x, this.y);
        }
        
    }

    public void update() {
        this.active = !this.active;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Sound getSound() {
        return this.sound;
    }

    public boolean isActive() {
        return this.active == true;
    }

    public void setStatus(boolean status) {
        this.active = status;
    }
}