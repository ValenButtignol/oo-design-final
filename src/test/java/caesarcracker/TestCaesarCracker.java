package caesarcracker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.LineNumberInputStream;
import java.io.StringBufferInputStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@SuppressWarnings("deprecation")
public class TestCaesarCracker {
    
    @ParameterizedTest
    @MethodSource("messageProvider")
    public void testCaesarCracker(String input, String expectedEncodedString, int shifts, int expectedLines) {
        StringBuilder encodedMessage = new StringBuilder();
        StringBuilder decodedMessage = new StringBuilder();
        LineNumberInputStream encoder = new LineNumberInputStream(
            new CaesarEncoder(
                new StringBufferInputStream(input), shifts, encodedMessage));

        int c;
        try {
            while ((c = encoder.read()) >= 0) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        int lines = encoder.getLineNumber();
        
        LineNumberInputStream decoder = new LineNumberInputStream(
            new CaesarDecoder(
                new StringBufferInputStream(encodedMessage.toString()), shifts, decodedMessage));
            
        try {
            while ((c = decoder.read()) >= 0) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int decodedLines = decoder.getLineNumber();

        System.out.println("Input: " + encodedMessage.toString());
        assertEquals(expectedLines, lines, decodedLines);
        assertEquals(expectedEncodedString, encodedMessage.toString());
        assertEquals(input, decodedMessage.toString());
    }   

    private static Stream<Object> messageProvider() {
        return Stream.of(
                Arguments.of("Hello, World!", "Khoor, Zruog!", 3, 0),
                Arguments.of("Hello\n World\n Once\n Again!", "Nkrru\n Cuxrj\n Utik\n Gmgot!", 6, 3),
                Arguments.of("Hola, Mundo\n De Nuevo!", "Gnkz, Ltmcn\n Cd Mtdun!", 25, 1)
        );
    }
}