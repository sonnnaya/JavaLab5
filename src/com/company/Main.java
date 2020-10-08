package com.company;

import com.company.IO.DataSource;
import com.company.IO.FileHandler;
import com.company.cryptography.Encryptor;
import com.company.handlers.StringHandler;
import com.company.handlers.TagCounter;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            var path = DataSource.getString("Enter path directory:");

            // Task #1
            var fileName = DataSource.getString("\nTask #1\nEnter file name:");
            var fileHandler = new FileHandler(path, fileName);

            var maxWordString = StringHandler.getMaximumWordStrings(fileHandler.readRows());
            View.printMessageAndInstance(View.LINE_WITH_MAX_WORD_COUNT, maxWordString);

            // Task #3
            var text = DataSource.getString("\nTask #3\nEnter text to encrypt:");

            fileName = DataSource.getString("Enter file name:");
            fileHandler = new FileHandler(path, fileName);

            var keySymbol = DataSource.getSymbol("Enter key symbol:");
            Encryptor.encrypt(fileHandler.getFile(), text, keySymbol);
            View.printMessageAndInstance(text + View.ENCRYPTION_COMPLETED, fileName);

            var decrypted = Encryptor.decrypt(fileHandler.getFile(), keySymbol);
            View.printMessageAndInstance(View.DECRYPTION_COMPLETED + fileName + ":\n", decrypted);

            // Task #4
            fileName = DataSource.getString("\nTask #4\nEnter file name:");
            fileHandler = new FileHandler(path, fileName);

            text = fileHandler.readAll();
//        var tags = DataSource.getString("Enter tags:");
            var tags = TagCounter.findAllHtmlTags(text);

            var tagCounter = new TagCounter(tags);
            var tagCountList = tagCounter.countTags(text);

            TagCounter.sortByCount(tagCountList);
            View.printMessageAndInstances(View.TAGS_AND_COUNTS, tagCountList);

            TagCounter.sortByTag(tagCountList);
            View.printMessageAndInstances(View.TAGS_AND_COUNTS, tagCountList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}