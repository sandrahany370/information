/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author JohnSandra
 */

    import java.io.*;
import java.util.*;

public class PasswordCracker {
    private static final String HARDCODED_PASSWORD = "abcde"; // Change this to your desired password

    public static boolean dictionaryAttack(String username) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("passwords.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.equals(HARDCODED_PASSWORD)) {
                System.out.println("Password found via dictionary attack: " + line);
                reader.close();
                return true;
            }
        }
        reader.close();
        return false;
    }

 public static boolean bruteForceAttack() {
    char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
    int maxLength = 5;

    for (int i = 0; i < Math.pow(chars.length, maxLength); i++) {
        StringBuilder attempt = new StringBuilder();

        int temp = i;
        for (int j = 0; j < maxLength; j++) {
            attempt.append(chars[temp % chars.length]);
            temp /= chars.length;
        }

        if (attempt.toString().equals(HARDCODED_PASSWORD)) {
            System.out.println("Password found via brute force attack: " + attempt);
            return true; // Stop further iterations once the password is found
        }
    }
    return false;
}

}


