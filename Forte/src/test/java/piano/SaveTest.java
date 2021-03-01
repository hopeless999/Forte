package piano;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SaveTest {
    Save s = new Save(0, 0, null);
    Block a = new Block(0, 0, null, null);
    Block[] b = {a};
    @Test
    public void test() {
        this.s.save(b);
        //assertEquals(b.length, this.s.getSavedBlocks().length);
    }
    
}