package texteditor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import texteditor.Buffer;
import texteditor.command.AddLineCommand;
import texteditor.command.DeleteLineCommand;
import texteditor.command.AddWordCommand;
import texteditor.command.DeleteWordCommand;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class TestCommands {
    
    private Buffer buffer;
    private AddLineCommand addLineCommand;
    private DeleteLineCommand deleteLineCommand;
    private AddWordCommand addWordCommand;
    private DeleteWordCommand deleteWordCommand;

    @BeforeEach
    public void setUp() {
        buffer = new Buffer();
        addLineCommand = new AddLineCommand(buffer);
        addWordCommand = new AddWordCommand(buffer);
        deleteLineCommand = new DeleteLineCommand(buffer);
        deleteWordCommand = new DeleteWordCommand(buffer);
    }

    @Test
    public void testAddLineCommand() {
        addLine(0, "Hello");
        addLine(1, "World");
        addLine(2, "!!!");
        assert(buffer.getBuffer().equals(List.of("Hello", "World", "!!!")));

        addLineCommand.undo();
        assert(buffer.getBuffer().equals(List.of("Hello", "World")));
    }

    @Test
    public void testAddWordCommand() {
        addLine(0, "Hello");
        addWord(0, 1, "World");
        assert(buffer.getBuffer().equals(List.of("Hello World")));

        addWordCommand.undo();
        assert(buffer.getBuffer().equals(List.of("Hello")));    
    }

    @Test
    public void testDeleteLineCommand() {
        addLine(0, "Hello");
        addLine(1, "World");
        
        deleteLine(0);
        assert(buffer.getBuffer().equals(List.of("World")));
        assertEquals(1, buffer.getBuffer().size());

        deleteLineCommand.undo();
        assert(buffer.getBuffer().equals(List.of("Hello", "World")));
        assertEquals(2, buffer.getBuffer().size());        
    }

    @Test
    public void testDeleteWordCommand() {
        addLine(0, "Hello World");
        addLine(1, "This is a test!");
        
        deleteWord(0, 1);
        assertEquals("Hello", buffer.getBuffer().get(0));
        assertEquals(2, buffer.getBuffer().size());     

        deleteWordCommand.undo();
        assertEquals("Hello World", buffer.getBuffer().get(0));
        assertEquals(2, buffer.getBuffer().size());        
    }

    private void addLine(int pos, String line) {
        addLineCommand.setLine(line);
        addLineCommand.setPos(pos);
        addLineCommand.execute();
    }

    private void deleteLine(int pos) {
        deleteLineCommand.setPos(pos);
        deleteLineCommand.execute();
    }

    private void addWord(int linePos, int wordPos, String word) {
        addWordCommand.setLinePos(linePos);
        addWordCommand.setWordPos(wordPos);
        addWordCommand.setWord(word);
        addWordCommand.execute();
    }

    private void deleteWord(int linePos, int wordPos) {
        deleteWordCommand.setLinePos(linePos);
        deleteWordCommand.setWordPos(wordPos);
        deleteWordCommand.execute();
    }
}



/* 
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
    } */
