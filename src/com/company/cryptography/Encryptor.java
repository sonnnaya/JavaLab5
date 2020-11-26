package com.company.cryptography;

import java.io.*;

import org.apache.log4j.Logger;

public class Encryptor {
    private static final Logger log = Logger.getLogger(Encryptor.class);

    public static void encrypt(File file, String source, int keySymbol) {
        log.debug("File's name for writing is " + file.getName());
        log.debug("Source is " + source);
        log.debug("Encryption-key is " + keySymbol);

        try (var inStream = new Coder(new FileWriter(file))) {
            for (var symbol : source.toCharArray())
                inStream.write(symbol, keySymbol);
            log.info("Text was encrypted into " + file.getName());
        } catch (IOException e) {
            log.error("Wrong directory.", e);
        }
    }

    public static String decrypt(File file, int keySymbol) {
        log.debug("File's name for reading is " + file.getName());
        log.debug("Decryption-key is " + keySymbol);

        char[] content = new char[1];
        try (var outStream = new Decoder(new FileReader(file))) {
            int symbolsAmount = (int) file.length() / 2;
            content = new char[symbolsAmount];
            int i = 0;

            while (outStream.ready()) {
                content[i] = (char) outStream.read(keySymbol);
                ++i;
            }
            log.info("Text was decrypted from " + file.getName());
            log.debug("Decrypted text is " + new String(content));
        } catch (FileNotFoundException e) {
            log.error("Wrong filename.", e);
        } catch (IOException e) {
            log.error("Wrong directory.", e);
        }
        return new String(content);
    }
}
