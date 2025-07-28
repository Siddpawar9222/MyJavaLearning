package G_OOPS.Relationships;

// MusicPlayer class (for Aggregation - can exist without Car)
class MusicPlayer {
    private final String brand;
    private String currentSong;

    public MusicPlayer(String brand) {
        this.brand = brand;
        this.currentSong = "No song playing";
    }

    public void play(String song) {
        this.currentSong = song;
        System.out.println(brand + " music player is playing: " + song);
    }

    public void stop() {
        this.currentSong = "No song playing";
        System.out.println(brand + " music player stopped");
    }

    public String getCurrentSong() {
        return currentSong;
    }
}