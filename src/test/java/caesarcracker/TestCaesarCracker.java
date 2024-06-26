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
    @MethodSource("encoderMessageProvider")
    public void testCaesarCrackerEncoder(String input, String expectedEncodedString, int shifts) {
        StringBuilder encodedMessage = new StringBuilder();
        CaesarEncoder encoder = new CaesarEncoder(new StringBufferInputStream(input), shifts, encodedMessage);

        int c;
        try {
            while ((c = encoder.read()) >= 0) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("Input: " + encodedMessage.toString());
        assertEquals(expectedEncodedString, encodedMessage.toString());
    }   

    private static Stream<Object> encoderMessageProvider() {
        return Stream.of(
                Arguments.of("Hello, World!", "Khoor, Zruog!", 3),
                Arguments.of("Hello\n World\n Once\n Again!", "Nkrru\n Cuxrj\n Utik\n Gmgot!", 6),
                Arguments.of("Hola, Mundo\n De Nuevo!", "Gnkz, Ltmcn\n Cd Mtdun!", 25)
        );
    }

    @ParameterizedTest
    @MethodSource("decoderMessageProvider")
    public void testCaesarCrackerDecoder(String encodedMessage, String expectedDecodedString, int shifts) {
        StringBuilder decodedMessage = new StringBuilder();
        CaesarDecoder decoder = new CaesarDecoder(new StringBufferInputStream(encodedMessage), shifts, decodedMessage);
        int c;
            
        try {
            while ((c = decoder.read()) >= 0) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(expectedDecodedString, decodedMessage.toString());
    }

    private static Stream<Object> decoderMessageProvider() {
        return Stream.of(
                Arguments.of("Khoor, Zruog!", "Hello, World!", 3),
                Arguments.of("Nkrru\n Cuxrj\n Utik\n Gmgot!", "Hello\n World\n Once\n Again!", 6),
                Arguments.of("Gnkz, Ltmcn\n Cd Mtdun!", "Hola, Mundo\n De Nuevo!", 25)
        );
    }
    
    @ParameterizedTest
    @MethodSource("lineCounterMessageProvider")
    public void testLineCounter(String input, String expectedEncodedString, int shifts, int expectedLines) {
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
        
        LineNumberInputStream decoder = new LineNumberInputStream(
            new CaesarDecoder(
                new StringBufferInputStream(encodedMessage.toString()), shifts, decodedMessage));
            
        try {
            while ((c = decoder.read()) >= 0) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int lines = encoder.getLineNumber();
        int decodedLines = decoder.getLineNumber();
        
        assertEquals(expectedEncodedString, encodedMessage.toString());
        assertEquals(input, decodedMessage.toString());
        assertEquals(expectedLines, lines, decodedLines);
    }   

    private static Stream<Object> lineCounterMessageProvider() {
        return Stream.of(
                Arguments.of("Hello, World!", "Khoor, Zruog!", 3, 0),
                Arguments.of("Hello\n World\n Once\n Again!", "Nkrru\n Cuxrj\n Utik\n Gmgot!", 6, 3),
                Arguments.of("Hola, Mundo\n De Nuevo!", "Gnkz, Ltmcn\n Cd Mtdun!", 25, 1)
        );
    }
}