import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.ArrayList;
import java.util.Scanner;

public class Midi {
    public static void main(String[] args) throws MidiUnavailableException{
        Scanner sc = new Scanner(System.in);
        String path = "D:\\GitHub\\rogue\\beginner-javascript\\snippets\\REMOTE\\homework #17 (midi)\\src\\notes";
        Synthesizer synth = MidiSystem.getSynthesizer();
        synth.open();
        MidiChannel[] channels = synth.getChannels();
        MidiChannel channel = channels[0];
        ArrayList<Note> notes = new ArrayList<>();
        // считывание нот
        while (true) {
            int inputNote = Musician.readNote(sc.nextLine());
            if (inputNote == -1) break;
            notes.add(new Note(inputNote));
        }
        // запись нот в файл
        Musician.writeSong(notes, path);
        // чтение нот из файла
        ArrayList<Note> notesFromFile = Musician.readSong(path);
        // воспроизведение последовательности нот
        Musician.playSong(notesFromFile, channel);
    }
}
