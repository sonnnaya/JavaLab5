package com.company.IO;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    private final File file;

    public FileHandler(String path, String name) throws IOException {
        file = new File(path, name);
        file.createNewFile();
    }

    public File getFile() {
        return file;
    }

    public ArrayList<String> readRows() throws IOException {
        var strings = new ArrayList<String>();

        try (var reader = new BufferedReader(new FileReader(file))) {
            while (reader.ready())
                strings.add(reader.readLine());
        }

        return strings;
    }

    public String readAll() throws IOException {
        var string = new StringBuilder();

        try (var reader = new BufferedReader(new FileReader(file))) {
            while (reader.ready())
                string.append(reader.readLine());
        }

        return string.toString();
    }

    public void write(ArrayList<String> strings) throws IOException {
        try (var writer = new BufferedWriter(new FileWriter(file))) {
            for (var string : strings)
                writer.write(string);
        }
    }

    public void write(String string) throws IOException {
        try (var writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(string);
        }
    }
}
