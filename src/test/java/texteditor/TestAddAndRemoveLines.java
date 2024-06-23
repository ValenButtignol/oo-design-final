package texteditor;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import texteditor.command.AddLineCommand;
import texteditor.command.DeleteLineCommand;

public class TestAddAndRemoveLines {
    
    private TextEditor buffer;
    private CommandManager commandManager;

    @BeforeEach
    public void setUp() {
        buffer = new TextEditor();
        commandManager = new CommandManager();
    }

    @ParameterizedTest
    @MethodSource("linesProvider")
    public void testAddLine(List<String> lines) {
        addLinesWithCommand(buffer, commandManager, lines);

        assert(buffer.getBuffer().equals(lines));
    }

    @ParameterizedTest
    @MethodSource("linesProvider")
    public void testDeleteLine(List<String> lines) {
        addLinesWithCommand(buffer, commandManager, lines);

        for(int i = lines.size()-1; i >= 0; i--) {
            commandManager.execute(new DeleteLineCommand(buffer, i));
            
            assertFalse(buffer.getBuffer().contains(lines.get(i)));
            assert(buffer.getBuffer().size() == i);
        }

        assert(buffer.getBuffer().isEmpty());
    }

    private static Stream<Object> linesProvider() {
        return Stream.of(
            Arguments.of(List.of("Hello", "World")),
            Arguments.of(List.of("This", "is", "a", "test")),
            Arguments.of(List.of("Another", "test"))
        );
    }

    private void addLinesWithCommand(TextEditor buffer, CommandManager commandManager, List<String> lines) {
        for(int i = 0; i < lines.size(); i++) {
            commandManager.execute(new AddLineCommand(buffer, i, lines.get(i)));
        }
    }
}
