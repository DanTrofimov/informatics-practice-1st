public class Note {
    public int channel = 0;
    public int note;
    public boolean singleThread = true;
    public int duration = 100;
    public int volume = 50;

    public Note(int note){
        this.note = note;
    }
}