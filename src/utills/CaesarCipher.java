package utills;

import data.Alphabet;

public class CaesarCipher {
    public static int key = 0;

    public static char encrypt(char symbol, int key) {
        char[] alphabet = Alphabet.getALPHABET();
        int length = alphabet.length;
        int newIndex;
        int index = -1;

        for (int i = 0; i < length; i++) {
            if (alphabet[i] == symbol) {
                index = i;
                break;
            }
        }
        newIndex = (index + key) % length;
        if (newIndex < 0) {
            newIndex += length;
        }

        return alphabet[newIndex];
    }

    public static char decrypt(char symbol, int key) {
        char[] alphabet = Alphabet.getALPHABET();
        int length = alphabet.length;
        int newIndex;
        int index = -1;

        for (int i = 0; i < length; i++) {
            if (alphabet[i] == symbol) {
                index = i;
                break;
            }
        }
        newIndex = (index - key) % length;
        if (newIndex < 0) {
            newIndex += length;
        }

        return alphabet[newIndex];
    }

    public static String bruteForceDecrypt(String text, int key) {
        char[] alphabet = Alphabet.getALPHABET();
        StringBuilder decrypted = new StringBuilder();
        int length = alphabet.length;
        int newIndex;

        for (char symbol : text.toCharArray()) {
            int index = -1;
            for (int i = 0; i < length; i++) {
                if (alphabet[i] == symbol) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                newIndex = (index - key + length) % length;
                decrypted.append(alphabet[newIndex]);
                CaesarCipher.key = newIndex;
            } else {
                decrypted.append(symbol);
            }
        }

        return decrypted.toString();
    }
}
