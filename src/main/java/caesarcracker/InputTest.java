package caesarcracker;

import java.io.IOException;
import java.io.LineNumberInputStream;
import java.io.StringBufferInputStream;

@SuppressWarnings("deprecation")
public class InputTest {
	public static void main(String[] args) throws IOException {
		int c;
		StringBuilder encodedMessage = new StringBuilder();
		StringBuilder decodedMessage = new StringBuilder();
		
		LineNumberInputStream encoder = new LineNumberInputStream(
			new CaesarEncoder(
				new StringBufferInputStream("Este\n Mensaje\n Sera\n Codificado"), 3, encodedMessage));
		
		while ((c = encoder.read()) >= 0) {
			System.out.print((char) c);
		}
		System.out.println();
		System.out.println();

		LineNumberInputStream decoder = new LineNumberInputStream(
				new CaesarDecoder(
					new StringBufferInputStream(encodedMessage.toString()), 3, decodedMessage));

		while ((c = decoder.read()) >= 0) {
			System.out.print((char) c);
		}
		System.out.println();
	}
}