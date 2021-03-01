package piano;

import org.junit.Test;
import static org.junit.Assert.*;

public class CursorTest {
    private Cursor c = new Cursor(48, 59, null);

    @Test
    public void moveTest() {
        assertTrue(c.move());
        assertFalse(c.move());
    }

    @Test
    public void resetTest() {
        c.move();
        c.reset();
        assertEquals(0, c.getVelocity());
    }

    @Test
    public void getTest() {
        assertEquals(48, c.getX());
    }

    @Test
    public void logicTest() {
        Cursor c2 = new Cursor(529, 59, null);
        c2.tick();
        assertEquals(48, c2.getX());
    }
}