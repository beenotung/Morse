import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;

public class Main {
	private static final int VOLUMERATE = 80;
	private static final int DURATIONRATE = 80;

	/**
	 * @param args
	 */
	public static void sound(int volume, int durationOn, int durationOff) {
		sound(volume, durationOn);
		sound(0, durationOff);
	}

	public static void sound(int volume, int duration) {
		try {
			int PIANO = 0;
			// int VOLUME = 80; // 0 - 127
			int VOLUME = (volume == 0 ? 0 : VOLUMERATE);
			int DURATION = duration * DURATIONRATE;

			Synthesizer synthesizer = MidiSystem.getSynthesizer();
			synthesizer.open();
			MidiChannel[] channels = synthesizer.getChannels();

			// start playing
			channels[PIANO].noteOn(60, VOLUME);
			Thread.sleep(DURATION);
			channels[PIANO].allNotesOff();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Demo();
		sound(1, 1, 1);
		sound(1, 1, 1);
		sound(0, 7);
		sound(1, 1, 1);
		sound(1, 1, 1);
		sound(1, 3, 1);
		sound(1, 1, 1);
	}

}
