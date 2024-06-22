package caesarcracker;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CaesarDecoder extends FilterInputStream {
    
    private StringBuilder decodedMessage;
    private int shifts; // amount of shifts to encode the input

    public CaesarDecoder(InputStream in, int shifts, StringBuilder decodedMessage) {
        super(in);
        this.shifts = shifts;
        this.decodedMessage = decodedMessage;
    }
    
    @Override
    public int read() throws IOException {
		int c = in.read();
        c = c == -1 ? c : decode((char) c);
        
        if (c != -1)
            decodedMessage.append((char) c);
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
}