package piano;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoadTest {
    Load l = new Load(0, 0, null);
    Block a = new Block(0, 0, null, null);
    Block[] b = {a};

    @Test
    public void test() {
        l.load(b);
    }

}