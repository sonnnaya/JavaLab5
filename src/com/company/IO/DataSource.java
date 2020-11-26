package com.company.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DataSource {
    public static String getString() throws IOException {
        var inStream = new BufferedReader(new InputStreamReader(System.in));
        return inStream.readLine();
    }

    public static int getSymbol() throws IOException {
        var inStream = new InputStreamReader(System.in);
        return inStream.read();
    }

    public static int getDigit() throws IOException {
        var inStream = new Scanner(System.in);
        return inStream.nextInt();
    }

    public static String getString(String message) throws IOException {
        System.out.println(message);
        var inStream = new BufferedReader(new InputStreamReader(System.in));
        return inStream.readLine();
    }

    public static int getSymbol(String message) throws IOException {
        System.out.println(message);
        var inStream = new InputStreamReader(System.in);
        return inStream.read();
    }
}
