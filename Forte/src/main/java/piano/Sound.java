package piano;
import javax.sound.midi.*;

public class Sound {
    private int noteNumber;
    private Synthesizer synthesizer;
    private MidiChannel channel;
    private int velocity;
    private int instrumentNo;
    
    public Sound(int noteNumber){
        this.noteNumber = noteNumber;
        this.velocity = 100;
        this.instrumentNo = 0; // default
    }

    public void play() throws MidiUnavailableException {
        this.synthesizer = MidiSystem.getSynthesizer();
        this.synthesizer.open();
        this.channel = this.synthesizer.getChannels()[0];
        this.channel.allNotesOff();
        Instrument currentInstrument = synthesizer.getAvailableInstruments()[this.instrumentNo];
        this.synthesizer.loadInstrument(currentInstrument);
        this.channel.programChange(currentInstrument.getPatch().getBank(), currentInstrument.getPatch().getProgram());
        this.channel.noteOn(this.noteNumber, this.velocity);
        
        // System.out.println(synthesizer.getAvailableInstruments().);
    }

    public void changeInstrument(String name) { 
        if(name ==  "Acoustic Grand Piano") {
            this.instrumentNo = 0;
        }
        if(name == "Marimba") {
            this.instrumentNo = 12;
        }
        if(name == "Banjo") {
            this.instrumentNo = 105;
        }
        if(name == "Alto Saxophone") {
            this.instrumentNo = 65;
        }

    }

    public MidiChannel getChannel() {
        return this.channel;
    }

    public int getNote() {
        return this.noteNumber;
    }

    // for testing only
    public int getInstrumentNo() {
        return this.instrumentNo;
    }
}