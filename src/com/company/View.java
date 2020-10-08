package com.company;

import com.company.handlers.TagCounter;

import java.util.ArrayList;

public class View {
    public static final String LINE_WITH_MAX_WORD_COUNT = "Line with maximum amount of words:\n";
    public static final String ENCRYPTION_COMPLETED = " was encrypted into ";
    public static final String DECRYPTION_COMPLETED = "Decrypted text from ";
    public static final String TAGS_AND_COUNTS = "\nTags and their amount in .html:";

    public static void printMessageAndInstances(String message, ArrayList<TagCounter.CountingResult> pairs) {
        System.out.println(message);
        for (var pair : pairs)
            System.out.println(pair.getTag() + "\t:\t" + pair.getAmount());
    }

    public static  <T> void printMessageAndInstance(String message, T object) {
        System.out.println(message + object.toString());
    }
}
