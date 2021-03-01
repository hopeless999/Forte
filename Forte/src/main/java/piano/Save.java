package piano;

import processing.core.PImage;
import processing.core.PApplet;
import java.io.*;

public class Save extends SingleIconFunction {
    private Block[] savedBlocks;

    public Save(int x, int y, PImage image) {
        super(x, y, image);
    }

    public void draw(PApplet app) {
        super.draw(app);
    }

    public void save(Block[] blocks) {
        
        try {
            // Write into temp.txt file
            PrintWriter out = new PrintWriter(new FileOutputStream("temp.txt", false));
            for(Block b : blocks) {
                if(b.isActive()) {
                    // Write 1 into file if active.
                    out.println("1");
                } else {
                    // Else write 0 into file.
                    out.println("0");
                }
            }
            out.close();
            
        } catch (FileNotFoundException e1) { 
            e1.printStackTrace();
        } 
    }

    public Block[] getSavedBlocks() {
        return this.savedBlocks;
    }
}