package piano;

import org.junit.Test;
import static org.junit.Assert.*;
import javax.sound.midi.*;
import processing.core.PApplet;
import processing.core.PImage;
import processing.event.MouseEvent;
import piano.App;

public class AppTest {
    @Test
    public void testApp(){
        App app = new App();
        PApplet.runSketch(new String[] {""}, app);
    }

}