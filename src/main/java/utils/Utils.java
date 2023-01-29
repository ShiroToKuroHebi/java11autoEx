package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.Instant;
import java.util.Random;

public class Utils {
    private static final String STATIC_ALPHABET = "ABCDEFJHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public static final Random rnd = new Random(Instant.now().getEpochSecond());
    public static final ObjectMapper objMapper = new ObjectMapper();

    public static String getAlphaStr(int len) {
        char[] buf = new char[len];
        for (int i = 0; i < len; i++) {
            buf[i] = STATIC_ALPHABET.charAt(rnd.nextInt(STATIC_ALPHABET.length()));
        }
        return new String(buf);
    }
}
