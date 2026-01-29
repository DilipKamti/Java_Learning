package java_13_design_patterns.structural;

/**
 * Covers:
 * - Convert interface of a class into another interface clients expect
 * - Allows classes to work together that otherwise couldn’t
 * - Common use-cases: Legacy system integration, third-party APIs
 */

public class AdapterExample {

    // ===== 1️⃣ Target Interface =====
    interface MediaPlayer {
        void play(String audioType, String fileName);
    }

    // ===== 2️⃣ Adaptee (Existing / Legacy Class) =====
    static class AdvancedMediaPlayer {
        public void playVlc(String fileName) {
            System.out.println("Playing VLC file: " + fileName);
        }

        public void playMp4(String fileName) {
            System.out.println("Playing MP4 file: " + fileName);
        }
    }

    // ===== 3️⃣ Adapter =====
    static class MediaAdapter implements MediaPlayer {
        private final AdvancedMediaPlayer advancedPlayer;

        public MediaAdapter(String audioType) {
            advancedPlayer = new AdvancedMediaPlayer();
        }

        @Override
        public void play(String audioType, String fileName) {
            switch (audioType.toLowerCase()) {
                case "vlc" -> advancedPlayer.playVlc(fileName);
                case "mp4" -> advancedPlayer.playMp4(fileName);
                default -> System.out.println("Invalid media type: " + audioType);
            }
        }
    }

    // ===== 4️⃣ Concrete Class / Client =====
    static class AudioPlayer implements MediaPlayer {
        private MediaAdapter adapter;

        @Override
        public void play(String audioType, String fileName) {
            if (audioType.equalsIgnoreCase("mp3")) {
                System.out.println("Playing MP3 file: " + fileName);
            } else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
                adapter = new MediaAdapter(audioType);
                adapter.play(audioType, fileName);
            } else {
                System.out.println("Invalid media type: " + audioType);
            }
        }
    }

    // ===== 5️⃣ Memory Hook / Easy Way to Remember =====
    /*
        💡 Adapter = convert incompatible interface → expected interface
        💡 Client uses Target interface
        💡 Adapter wraps the Adaptee
    */

    // ===== 6️⃣ Interview Tips / Tricks =====
    /*
        🔹 Difference between Adapter and Decorator?
            - Adapter: converts interface to match client expectation
            - Decorator: adds responsibilities dynamically
        🔹 When to use Adapter?
            - Legacy system integration
            - Third-party API adaptation
        🔹 Common interview examples: Media player, Payment gateway, Database adapter
        🔹 Often asked: implement simple Adapter for Audio player
    */

    // ===== 7️⃣ Test / Demo =====
    public static void main(String[] args) {
        MediaPlayer player = new AudioPlayer();

        player.play("mp3", "song.mp3");
        player.play("mp4", "movie.mp4");
        player.play("vlc", "video.vlc");
        player.play("avi", "unknown.avi"); // invalid type
    }
}

