package caesarcracker;

import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberInputStream;
import java.io.StringBufferInputStream;

@SuppressWarnings("deprecation")
public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder encodedMessage = new StringBuilder();
		Integer shifts = 3;
		
		InputStream encoder = new LineNumberInputStream(
            new CaesarEncoder(
                new StringBufferInputStream("Este\n Mensaje\n Sera\n Codificado"), shifts));

        int c;

		while ((c = encoder.read()) >= 0) {
			encodedMessage.append((char) c);
		}
		System.out.println(encodedMessage);
		System.out.println();

        InputStream decoder = new LineNumberInputStream(
            new CaesarDecoder(
                new StringBufferInputStream(encodedMessage.toString()), shifts));
            
		while ((c = decoder.read()) >= 0) {
			System.out.print((char) c);
		}

		System.out.println();
	}
}