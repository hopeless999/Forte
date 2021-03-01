package piano;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import processing.core.PImage;

public class InstrumentButtonTest {
    PImage[] images = new PImage[4];
    InstrumentButton in = new InstrumentButton(0, 0, images);

    @Test
    public void previousNextTest() {
        assertEquals(0, in.getIndex());
        assertEquals("Acoustic Grand Piano", in.getName());
        in.next();
        assertEquals(1, in.getIndex());
        assertEquals("Marimba", in.getName());
        in.setIndex(3);
        in.next();
        assertEquals(0, in.getIndex());
        assertEquals("Acoustic Grand Piano", in.getName());
        in.previous();
        assertEquals(3, in.getIndex());
        assertEquals("Alto Saxophone", in.getName());
        in.previous();
        assertEquals("Banjo", in.getName());
    }
}