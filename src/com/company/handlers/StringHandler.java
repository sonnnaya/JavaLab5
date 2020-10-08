package com.company.handlers;

import java.io.IOException;
import java.util.ArrayList;

public class StringHandler {
    public static String getMaximumWordStrings(ArrayList<String> strings) throws IOException {
        var maxWordString = new String();
        int maxWordAmount = 0;

        for (var string : strings) {
            String[] bufferWords = string.split(" ");

            if (bufferWords.length > maxWordAmount) {
                maxWordString = string;
                maxWordAmount = bufferWords.length;
            }
        }

        return maxWordString;
    }
}
