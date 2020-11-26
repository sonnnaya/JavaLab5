package com.company;

import com.company.IO.DataSource;
import com.company.IO.FileHandler;
import com.company.cryptography.Encryptor;

import java.io.IOException;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        try {
            Locale.setDefault(new Locale("en", "GB"));

            View.printMessage(View.LOCALE_MENU);
            View.printMessage(View.getInputCommandDigit());
            var command = DataSource.getDigit();
            View.setBundler(chooseLocal(command));

            var text = DataSource.getString(View.getInputTextEncryption());

            var fileName = DataSource.getString(View.getInputFileName());
            var fileHandler = new FileHandler("resources", fileName);

            var keySymbol = DataSource.getSymbol(View.getInputKeySymbol());

            Encryptor.encrypt(fileHandler.getFile(), text, keySymbol);
            View.printMessageAndInstance(text + " " + View.getEncryptionCompleted(), fileName);

            var decrypted = Encryptor.decrypt(fileHandler.getFile(), keySymbol);
            View.printMessageAndInstance(View.getDecryptionCompleted() + fileName + ":\n", decrypted);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Locale chooseLocal(int digit) {
        return switch (digit) {
            case 1 -> new Locale("en", "GB");
            case 2 -> new Locale("ua", "UA");
            case 3 -> new Locale("ru", "RU");
            default -> Locale.getDefault();
        };
    }
}