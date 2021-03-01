package piano;

import org.junit.Test;
import static org.junit.Assert.*;

public class ClearTest {
    Block a = new Block(0, 0, null, null);
    Block[] b = {a};
    Clear c = new Clear(0, 0, null, b);
    
    @Test
    public void test() {
        b[0].setStatus(true);
        c.clear();
        assertFalse(b[0].isActive());
    }
}