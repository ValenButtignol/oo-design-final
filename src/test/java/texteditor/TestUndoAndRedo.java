package texteditor;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import texteditor.command.AddLineCommand;
import texteditor.command.DeleteLineCommand;

public class TestUndoAndRedo {
    
    private TextEditor buffer;
    private CommandManager commandManager;

    @BeforeEach
    public void setUp() {
        buffer = new TextEditor();
        commandManager = new CommandManager();

        commandManager.execute(new AddLineCommand(buffer, 0, "Hello"));
        commandManager.execute(new AddLineCommand(buffer, 1, "World"));
        commandManager.execute(new AddLineCommand(buffer, 2, "This"));
        commandManager.execute(new AddLineCommand(buffer, 3, "is"));
        commandManager.execute(new AddLineCommand(buffer, 4, "a"));
        commandManager.execute(new AddLineCommand(buffer, 5, "test"));
    }


    @Test
    public void testUndoAndRedoWithAddLines() {
        
        commandManager.undo();
        commandManager.undo();
        commandManager.undo();

        assert(buffer.getBuffer().equals(List.of("Hello", "World", "This")));

        commandManager.redo();
        commandManager.redo();
        commandManager.redo();

        assert(buffer.getBuffer().equals(List.of("Hello", "World", "This", "is", "a", "test")));
    }

    @Test
    public void testUndoAndRedoWithRemoveLines() {
        
        commandManager.execute(new DeleteLineCommand(buffer, 5));
        commandManager.execute(new DeleteLineCommand(buffer, 4));
        commandManager.execute(new DeleteLineCommand(buffer, 3));

        assert(buffer.getBuffer().equals(List.of("Hello", "World", "This")));

        commandManager.undo();
        commandManager.undo();
        commandManager.undo();

        assert(buffer.getBuffer().equals(List.of("Hello", "World", "This", "is", "a", "test")));

        commandManager.redo();
        commandManager.redo();
        commandManager.redo();

        assert(buffer.getBuffer().equals(List.of("Hello", "World", "This")));
    }

}