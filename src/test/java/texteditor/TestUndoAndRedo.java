/* package texteditor;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import texteditor.command.AddLineCommand;
import texteditor.command.AddWordCommand;
import texteditor.command.DeleteLineCommand;
import texteditor.command.DeleteWordCommand;

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

    @Test
    public void testUndoAndRedoWithAddWords() {
        
        commandManager.execute(new AddWordCommand(buffer, 0, 0, "Hi"));
        commandManager.execute(new AddWordCommand(buffer, 1, 0, "There"));
        commandManager.execute(new AddWordCommand(buffer, 2, 0, "Everyone"));

        
        assert(buffer.getBuffer().equals(List.of("Hi Hello", "There World", "Everyone This", "is", "a", "test")));

        commandManager.undo();
        commandManager.undo();
        commandManager.undo();

        assert(buffer.getBuffer().equals(List.of("Hello", "World", "This", "is", "a", "test")));

        commandManager.redo();
        commandManager.redo();
        commandManager.redo();

        assert(buffer.getBuffer().equals(List.of("Hi Hello", "There World", "Everyone This", "is", "a", "test")));
    }

    @Test
    public void testUndoAndRedoWithDeleteWords() {
            
            commandManager.execute(new AddWordCommand(buffer, 0, 0, "Hi"));
            commandManager.execute(new AddWordCommand(buffer, 1, 0, "There"));
            commandManager.execute(new AddWordCommand(buffer, 2, 0, "Everyone"));
    
            commandManager.execute(new DeleteWordCommand(buffer, 0, 0));
            commandManager.execute(new DeleteWordCommand(buffer, 1, 0));
            commandManager.execute(new DeleteWordCommand(buffer, 2, 0));
    
            assert(buffer.getBuffer().equals(List.of("Hello", "World", "This", "is", "a", "test")));
    
            commandManager.undo();
            commandManager.undo();
            commandManager.undo();
    
            assert(buffer.getBuffer().equals(List.of("Hi Hello", "There World", "Everyone This", "is", "a", "test")));
    
            commandManager.redo();
            commandManager.redo();
            commandManager.redo();
    
            assert(buffer.getBuffer().equals(List.of("Hello", "World", "This", "is", "a", "test")));
    }
} */