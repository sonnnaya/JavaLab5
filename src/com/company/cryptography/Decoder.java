package com.company.cryptography;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class Decoder extends FilterReader {
    protected Decoder(Reader in) {
        super(in);
    }

    public int read(int keySymbol) throws IOException {
        return super.read() - keySymbol;
    }
}
