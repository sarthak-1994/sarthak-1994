package utils;

import java.util.Random;

public class RandomUtil {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final Random random = new Random();

    private static final String[] WORDS = {
            "quick", "brown", "fox", "jumps", "over", "lazy", "dog", "happy", "runs", "fast", "blue", "sky", "bright", "sun", "green", "grass"
    };

    public static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    public static String getRandomSentence(int wordCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordCount; i++) {
            if (i > 0) sb.append(" ");
            sb.append(WORDS[random.nextInt(WORDS.length)]);
        }
        sb.append(".");
        return sb.substring(0, 1).toUpperCase() + sb.substring(1);
    }
}
