package piano;
import processing.core.PApplet;
import processing.core.PImage;

public class InstrumentButton extends MultipleIconsFunction {
    private int index;
    private String currInstrumentName;

    public InstrumentButton(int x, int y, PImage[] images) {
        super(x, y, images);
        this.index = 0;
        this.currInstrumentName = "Acoustic Grand Piano"; // default
    }

    public void draw(PApplet app) {
        app.image(this.images[index], this.x, this.y);
    }

    public void next() {
        if(this.index == 3){
            this.index = 0;
        } else {
            this.index++;
        }
        this.change();
    }

    public void previous() {
        if(this.index == 0) {
            this.index = 3;
        } else {
            this.index--;
        }
        this.change();
    }

    public void change() {
        if(this.index == 0) {
            this.currInstrumentName = "Acoustic Grand Piano";
        }
        if(this.index == 1) {
            this.currInstrumentName = "Marimba";
        }
        if(this.index == 2) {
            this.currInstrumentName = "Banjo";
        }
        if(this.index == 3) {
            this.currInstrumentName = "Alto Saxophone";
        }
    }

    public String getName() {
        return this.currInstrumentName;
    }

    // for testing only
    public void setIndex(int i) { 
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }
}