package com.company.cryptography;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class Coder extends FilterWriter {
    protected Coder(Writer out) {
        super(out);
    }

    public void write(int c, int keySymbol) throws IOException {
        super.write(c + keySymbol);
    }
}
