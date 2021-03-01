package piano;

import processing.core.PImage;
import processing.core.PApplet;

public class Clear extends SingleIconFunction {
    private Block[] blocks;

    public Clear(int x, int y, PImage image, Block[] blocks) {
        super(x, y, image);
        this.blocks = blocks;
    }

    public void draw(PApplet app) {
        app.image(this.image, this.x, this.y);
    }

    public void clear() {
        for(Block b : this.blocks) {
            if(b.isActive()) {
                b.update();
            }
        }

    }




}