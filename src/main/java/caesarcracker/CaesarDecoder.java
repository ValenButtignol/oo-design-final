package caesarcracker;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CaesarDecoder extends FilterInputStream {
    
    private StringBuilder decodedMessage;
    private int shifts; // amount of shifts to encode the input

    public CaesarDecoder(InputStream in, int shifts) {
        super(in);
        this.shifts = shifts;
        decodedMessage = new StringBuilder();
    }
    
    @Override
    public int read() throws IOException {
		int c = in.read();
        if (c != -1) {
            c = decode((char) c);
            decodedMessage.append(c);
        }
		return c;
	}

    private char decode(char c) {
        if (Character.isLetter(c)) {
            char base = Character.isLowerCase(c) ? 'a' : 'A';
            // Adjust the shift direction
            int decodedShift = (26 - shifts) % 26;
            return (char) (((c - base + decodedShift) % 26) + base);
        } else {
            return c; // Return unchanged for non-letter characters
        }
    }

    public String getDecodedMessage() {
        return decodedMessage.toString();
    }
}