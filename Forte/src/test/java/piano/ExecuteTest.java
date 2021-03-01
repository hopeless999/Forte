package piano;

import processing.core.PImage;
import org.junit.Test;
import static org.junit.Assert.*;

public class ExecuteTest {
    PImage a = new PImage(10,10);
    PImage b = new PImage();
    PImage[] ls = {a, b};
    PImage[] ls2 = new PImage[2];
    Execute e = new Execute(5, 5, ls);
    Execute e2 = new Execute(0, 0, ls2);

    @Test
    public void updateTest() {
        assertEquals(ls[0], e.getCurr());
        e.update();
        assertEquals(ls[1], e.getCurr());
        e.update();
        assertEquals(ls[0], e.getCurr());
        e2.update();
    }

    @Test
    public void resetTest() {
        e.reset();
        assertEquals(ls[0], e.getCurr());
    }
}