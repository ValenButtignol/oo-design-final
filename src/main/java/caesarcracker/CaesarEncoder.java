package caesarcracker;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CaesarEncoder extends FilterInputStream {

    private int shifts; // amount of shifts to encode the input

    public CaesarEncoder(InputStream in, int shifts) {
        super(in);
        this.shifts = shifts;
    }

    @Override
    public int read() throws IOException {
		int c = in.read();
        if (c != -1) {
            c = encode((char) c);
        }
		return c;
	}

    private char encode(char c) {
        if (Character.isLetter(c)) {
            char base = Character.isLowerCase(c) ? 'a' : 'A';
            return (char) (((c - base + shifts) % 26) + base);
        } else {
            return c; // Return unchanged for non-letter characters
        }
    }
}