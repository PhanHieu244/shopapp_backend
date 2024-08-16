package vn.edu.hust.project.appledeviceservice.utils;

import java.security.SecureRandom;

public class RandomStringUtils {
    private static final String CHAR_POOL = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int STRING_LENGTH = 10;

    public static String generateRandomString() {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(STRING_LENGTH);

        for (int i = 0; i < STRING_LENGTH; i++) {
            int randomIndex = random.nextInt(CHAR_POOL.length());
            char randomChar = CHAR_POOL.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
