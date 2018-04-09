public class AudioPlayer implements  MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String filename) {
        // internal support
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("playing mp3 file. Name: " + filename);
        }
        // media Adapter support ways
        else if (audioType.equalsIgnoreCase("vlc")
                || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, filename);
        } else {
            System.out.println(String.format("invalid media. %s format not supported.", audioType));
        }
    }
}
