import javax.sound.midi.MidiChannel;
import java.util.ArrayList;
import java.io.*;

public class Musician {
    // запись нот в файл
    public static void writeSong(ArrayList<Note> notes, String path) {
        try(FileWriter writer = new FileWriter(path)) {
            for (int i = 0; i < notes.size(); i++){
                writer.write(notes.get(i).note + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // чтение нот с файла
    public static ArrayList<Note> readSong(String path) {
        ArrayList<Note> arrNotes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null){
                int note = Integer.parseInt(line);
                arrNotes.add(new Note(note));
            }
            return arrNotes;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // проиграть последовательность нот
    public static void playSong(ArrayList<Note> notes, MidiChannel channel) {
        try {
            for (int i = 0; i < notes.size(); i++){
                Musician musician = new Musician();
                for (Note note : notes) {
                    playNote(note, channel);
                    Thread.sleep(100);
                }
                for (Note note : notes) {
                    stopPlayNote(note, channel);
                }
            }
        } catch (InterruptedException ex) {
            System.out.println("Channel is interrupted.");
        }
    }

    // проиграть конкретную ноту
    public static void playNote(Note note, MidiChannel channel) {
        channel.noteOn(note.note, note.volume);
    }

    // прекратить проигрывание
    public static void stopPlayNote(Note note, MidiChannel channel) {
        channel.noteOff(note.note);
    }

    // преобразовывает ноты в цифровой формат
    public static int readNote(String note) {
        switch (note) {
            case "A":
                return 9;
            case "B":
                return 11;
            case "C":
                return 0;
            case "D":
                return 2;
            case "E":
                return 4;
            case "F":
                return 5;
            case "G":
                return 7;
            default:
                return -1;
        }
    }
}
