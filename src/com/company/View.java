package com.company;

import com.company.handlers.TagCounter;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class View {
    private static final String LINE_WITH_MAX_WORD_COUNT = "Line with maximum amount of words:\n";
    private static final String TAGS_AND_COUNTS = "\nTags and their amount in .html:";

    private static final String PROPERTIES_NAME = "bundle";
    public static final String LOCALE_MENU = "1 - english\n2 - українська\n3 - русский";
    private static ResourceBundle bundler = ResourceBundle.getBundle(PROPERTIES_NAME, new Locale("en", "GB"));

    private static final String ENCRYPTION_COMPLETED = " was encrypted into ";
    private static final String DECRYPTION_COMPLETED = "Decrypted text from ";
    private static final String INPUT_COMMAND_DIGIT = "Choose localization: \n";
    private static final String INPUT_TEXT_ENCRYPTION = "Enter text to encrypt:";
    private static final String INPUT_FILE_NAME = "Enter file name:";
    private static final String INPUT_KEY_SYMBOL = "Enter key symbol:";


    public static void setBundler(Locale locale) {
        bundler = ResourceBundle.getBundle(PROPERTIES_NAME, locale);
    }

    public static String getInputCommandDigit() {
        return bundler.getString("INPUT_COMMAND_DIGIT");
    }

    public static String getDecryptionCompleted() {
        return bundler.getString("DECRYPTION_COMPLETED");
    }

    public static String getEncryptionCompleted() {
        return bundler.getString("ENCRYPTION_COMPLETED");
    }

    public static String getInputTextEncryption() {
        return bundler.getString("INPUT_TEXT_ENCRYPTION");
    }

    public static String getInputFileName() {
        return bundler.getString("INPUT_FILE_NAME");
    }

    public static String getInputKeySymbol() {
        return bundler.getString("INPUT_KEY_SYMBOL");
    }

    public static void printMessageAndInstances(String message, ArrayList<TagCounter.CountingResult> pairs) {
        System.out.println(message);
        for (var pair : pairs)
            System.out.println(pair.getTag() + "\t:\t" + pair.getAmount());
    }

    public static  <T> void printMessageAndInstance(String message, T object) {
        System.out.println(message + object.toString());
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
