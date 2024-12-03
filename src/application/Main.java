package application;

import data.Texts;
import utills.FileHandler;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        int userСhoice;

        System.out.println(Texts.WELCOME_TEXT_RU);

        do {
            System.out.println(Texts.ACTION_SELECTION_RU);
            userСhoice = console.nextInt();
            console.nextLine();

            if (userСhoice == 1) {
                boolean isEncrypt = true;

                System.out.println(Texts.Encrypt_RU);

                System.out.println(Texts.ENTER_INPUT_FILE_PATH_RU);
                String fileInputName = console.nextLine();

                System.out.println(Texts.ENTER_OUTPUT_FILE_PATH_RU);
                String fileOutputName = console.nextLine();

                System.out.println(Texts.ENTER_SHIFT_VALUE_RU);
                int key = console.nextInt();

                console.nextLine();

                FileHandler.processFile(fileInputName, fileOutputName, key, isEncrypt);
                System.out.println(Texts.FILE_SAVED_RU);

            } else if (userСhoice == 2) {
                boolean isEncrypt = false;

                System.out.println(Texts.DECRYPTING_TEXT_RU);

                System.out.println(Texts.ENTER_INPUT_FILE_PATH_RU);
                String fileInputName = console.nextLine();

                System.out.println(Texts.ENTER_OUTPUT_FILE_PATH_RU);
                String fileOutputName = console.nextLine();

                System.out.println(Texts.DO_YOU_KNOW_KEY_RU);
                int knownKey = console.nextInt();

                if (knownKey == 2) {
                    System.out.println(Texts.HELP_DECRYPT_TEXT_RU);
                    FileHandler.processFile(fileInputName, fileOutputName, console);
                } else if (knownKey == 1) {
                    System.out.println(Texts.DO_YOU_KNOW_KEY_RU);
                    int key = console.nextInt();

                    console.nextLine();
                    System.out.println(Texts.FILE_SAVED_RU);
                    FileHandler.processFile(fileInputName, fileOutputName, key, isEncrypt);
                }

            } else if (userСhoice == 3) {
                System.out.println("Выход из программы.");
                break;
            } else {
                return;
            }
        }
        while (true);
    }
}
