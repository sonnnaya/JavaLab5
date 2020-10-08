package com.company.cryptography;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Encryptor {
    public static void encrypt(File file, String source, int keySymbol) throws IOException {
        try (var inStream = new Coder(new FileWriter(file))) {
            for (var symbol : source.toCharArray())
                inStream.write(symbol, keySymbol);
        }
    }

    public static String decrypt(File file, int keySymbol) throws IOException {
        try (var outStream = new Decoder(new FileReader(file))) {
            int symbolsAmount = (int) file.length() / 2;
            char[] content = new char[symbolsAmount];
            int i = 0;

            while (outStream.ready()) {
                content[i] = (char) outStream.read(keySymbol);
                ++i;
            }

            return new String(content);
        }
    }
}
