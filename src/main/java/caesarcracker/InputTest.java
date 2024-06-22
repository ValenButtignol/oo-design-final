package caesarcracker;

import java.io.*;

public class InputTest {
	public static void main(String[] args) throws IOException {
		int c;
		InputStream in = null;
		try {
			in = new LineNumberInputStream(
					new CaesarEncoder(
						new FileInputStream("test.txt"), 3));

			while((c = in.read()) >= 0) {
				System.out.print((char)c);
			}

			LineNumberInputStream lineInputStream =	(LineNumberInputStream) in;
			int lines = lineInputStream.getLineNumber();

			CaesarEncoder caesarEncoder = (CaesarEncoder) in;
			String encodedMessage = caesarEncoder.getEncodedMessage();

			System.out.println();
			System.out.println("Line count of the encoded message" + lines);

			InputStream in2 = new LineNumberInputStream(
					new CaesarDecoder(
						new StringBufferInputStream(encodedMessage), 3));

			lines = lineInputStream.getLineNumber();
			
			System.out.println();
			System.out.println("Line count of the decoded message" + lines);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) { in.close(); }
		}
	}
}