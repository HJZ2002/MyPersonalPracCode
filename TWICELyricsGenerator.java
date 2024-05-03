import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TWICELyricsGenerator {
    public static void main(String[] args) {
        List<String> lyrics = generateLyrics();
        
        for (String line : lyrics) {
            System.out.println(line);
        }
    }
    
    private static List<String> generateLyrics() {
        List<String> lyrics = new ArrayList<>();
        
        lyrics.add("When I first met you, I didn't know");
        lyrics.add("That you'd be the best thing I ever did");
        lyrics.add("Every day with you is a gift");
        lyrics.add("You're the reason why I smile");
        
        lyrics.add("");
        
        lyrics.add("Through the ups and downs");
        lyrics.add("You've always been there");
        lyrics.add("With you, I can face anything");
        lyrics.add("Together, we can overcome it all");
        
        lyrics.add("");
        
        lyrics.add("You're my shining star");
        lyrics.add("Guiding me through the darkest nights");
        lyrics.add("With you, I'm not afraid");
        lyrics.add("To take on the world, hand in hand");
        
        lyrics.add("");
        
        lyrics.add("Every moment spent with you");
        lyrics.add("Is a treasure I hold dear");
        lyrics.add("You're my everything");
        lyrics.add("The best thing I ever did");
        
        return lyrics;
    }
}