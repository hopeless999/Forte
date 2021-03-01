package piano;

import java.io.*;
import processing.core.PApplet;
import processing.core.PImage;

public class Load extends SingleIconFunction {
    public Load(int x, int y, PImage image) {
        super(x, y, image);
    }

    public void draw(PApplet app) {
        super.draw(app);
    }

    public Block[] load(Block[] blocks) {
            int i = 0;
            try (BufferedReader br = new BufferedReader(new FileReader("temp.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.contains("0")){
                        blocks[i].setStatus(false);
                    } else {
                        blocks[i].setStatus(true);
                    } 
                    i++;
                }
            } catch (IOException e) {
                return null;
            }
        

        return blocks;
    }
}