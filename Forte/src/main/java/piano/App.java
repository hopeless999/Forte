package piano;

import javax.sound.midi.*;
import processing.core.PApplet;
import processing.core.PImage;
import processing.event.MouseEvent;

public class App extends PApplet {
    private PImage banner;
    private PImage middleBanner;
    private PImage keyboard;
    private PImage buttonBack;
    private PImage grid;
    private PImage blockImage;
    private PImage stop;
    private PImage previous;
    private PImage next;

    private Cursor cursor;
    private Execute button;
    private Block block;
    private Sound sound;
    private Clear clear;
    private Save save;
    private Load load;
    private InstrumentButton instrumentButton;
    private Block temp;

    private Block[] blocksList;
    private PImage[] buttonImageList;
    private PImage[] instrumentIcons;

    public App() {
        // Initialise variables here
        this.blocksList = new Block[416];
        this.buttonImageList = new PImage[2]; // play and pause images
        this.instrumentIcons = new PImage[4]; // instruments
    }

    public void settings() {
        // Don't touch
        size(540, 335);
    }

    public void setup() {
        frameRate(60);
        // Load images here
        this.banner = this.loadImage("src/main/resources/banner.png");
        this.blockImage = this.loadImage("src/main/resources/block.png");
        this.buttonBack = this.loadImage("src/main/resources/buttonBack.png");
        this.grid = this.loadImage("src/main/resources/grid.png");
        this.keyboard = this.loadImage("src/main/resources/keyboard.png");
        this.middleBanner = this.loadImage("src/main/resources/middleBanner.png");
        this.cursor = new Cursor(48, 59, this.loadImage("src/main/resources/pointer.png"));
        this.buttonImageList[0] = this.loadImage("src/main/resources/play.png"); // play (default)
        this.buttonImageList[1] = this.loadImage("src/main/resources/pause.png"); // pause
        this.button = new Execute(5, 5, buttonImageList);
        this.stop = this.loadImage("src/main/resources/stop.png");
        this.clear = new Clear(95, 5, this.loadImage("src/main/resources/reset.png"), blocksList);
        this.save = new Save(140, 5, this.loadImage("src/main/resources/save.png"));
        this.load = new Load(185, 5, this.loadImage("src/main/resources/load.png"));
        int i = 0;
        for (int x = 61; x < 541; x = x + 15) {
            int y = 76;
            int noteNum = 72; // MIDI number, 72 corresponds to the top one which is C5
            while (y < 336) {
                this.sound = new Sound(noteNum);
                this.block = new Block(x, y, blockImage, sound); // stores coordinates, image and sound for the block
                this.blocksList[i] = this.block;
                y = y + 20;
                i++;
                noteNum--;
            }
        }
        this.previous = this.loadImage("src/main/resources/prev.png");
        this.next = this.loadImage("src/main/resources/next.png");
        this.instrumentIcons[0] = this.loadImage("src/main/resources/P.png");
        this.instrumentIcons[1] = this.loadImage("src/main/resources/M.png");
        this.instrumentIcons[2] = this.loadImage("src/main/resources/B.png");
        this.instrumentIcons[3] = this.loadImage("src/main/resources/S.png");
        this.instrumentButton = new InstrumentButton(320, 5, instrumentIcons);

    }

    public void draw() {
        // Draw your program here
        loop();
        this.cursor.tick();
        this.image(this.middleBanner, 0, 0);
        this.image(this.banner, 0, 0);
        this.image(this.buttonBack, 5, 5);
        this.button.draw(this); // play and pause
        this.image(this.buttonBack, 50, 5);
        this.image(this.stop, 50, 5); // stop
        this.image(this.buttonBack, 95, 5);
        this.clear.draw(this); // clear
        this.image(this.buttonBack, 140, 5);
        this.save.draw(this); // save
        this.image(this.buttonBack, 185, 5);
        this.load.draw(this); // load
        this.image(this.buttonBack, 275, 5);
        this.image(this.previous, 275, 5); // previous
        this.image(this.buttonBack, 320, 5);
        this.instrumentButton.draw(this); // instruments
        this.image(this.buttonBack, 365, 5);
        this.image(this.next, 365, 5); // next
        this.image(this.keyboard, 0, 75);
        this.image(this.grid, 60, 75);
        this.cursor.draw(this);
        for (Block b : blocksList) {
            b.draw(this);
        }
        for (Block b : blocksList) {
            if (this.cursor.getX() + 12 == b.getX() && b.isActive()) { 
                try {
                    b.getSound().play();
                    this.temp = b;
                } catch (MidiUnavailableException e) {
                    e.printStackTrace();
                }
            }
            if (this.cursor.getX() + 12 == b.getX() + 15 && b.isActive()) {
                this.temp.getSound().getChannel().allNotesOff();
            }
        }
    }

    public void mousePressed(final MouseEvent e) {
        loop();
        // get where mouse is clicked
        final int x = e.getX();
        final int y = e.getY();

        // buttons are 40 x 40 pixels

        if(y > 5 && y < 45) {
            // play and pause (5,5)
            if (x > 5 && x < 45) {
                this.cursor.move();
                this.button.update();
            }
            // stop (50, 5)
            if (x > 50 && x < 90) {
                this.cursor.reset();
                this.button.reset();
            }
            // clear (95, 5)
            if (x > 95 && x < 135) {
                this.clear.clear();
                redraw();
            }
            // save (140, 5)
            if (x > 140 && x < 180) {
                this.save.save(this.blocksList);
                if(this.cursor.getVelocity() != 0) {
                    this.cursor.move();
                    this.button.update();
                }
            }
            // load (185, 5)
            if (x > 185 && x < 225) {
                this.blocksList = this.load.load(this.blocksList);
                redraw();
            }
            // previous (275, 5)
            if (x > 275 && x < 315) {
                this.instrumentButton.previous();
                for(Block b : blocksList) {
                    b.getSound().changeInstrument(this.instrumentButton.getName());
                }
                redraw();
            }

            if (x > 365 && x < 405) {
                this.instrumentButton.next();
                for(Block b : blocksList) {
                    b.getSound().changeInstrument(this.instrumentButton.getName());
                }
                redraw();
            }
            
        }

        // blocks
        if (x > 60 && y > 75) {
            for (Block b : blocksList) {
                if (x > b.getX() && x < b.getX() + 15 && y > b.getY() && y < b.getY() + 15) {
                    b.update();
                    redraw();
                }
            }
            
        }
    }

    public static void main(final String[] args) {
        // Don't touch this
        PApplet.main("piano.App");
    }
}