package piano;

import org.junit.Test;
import static org.junit.Assert.*;

import javax.sound.midi.MidiUnavailableException;

public class SoundTest {
    Sound s = new Sound(60);

    @Test
    public void init() {
        try {
            s.play();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getTest() {
        assertEquals(60, s.getNote());
    }

    @Test 
    public void changeTest() {
        s.changeInstrument("Marimba");
        assertEquals(12, s.getInstrumentNo());
        s.changeInstrument("Acoustic Grand Piano");
        assertEquals(0, s.getInstrumentNo());
        s.changeInstrument("Banjo");
        assertEquals(105, s.getInstrumentNo());
        s.changeInstrument("Alto Saxophone");
        assertEquals(65, s.getInstrumentNo());

    }
}