package texteditor.command;


import texteditor.TextEditor;

public class AddWordCommand implements Command {
    private int linePos;
    private int pos;
    private String word;
    private TextEditor editor;

    public AddWordCommand(TextEditor editor, int linePos, int pos, String word) {
        this.linePos = linePos;
        this.pos = pos;
        this.word = word;
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.addWord(linePos, pos, word);
    }

    @Override
    public void undo() {
        editor.deleteWord(linePos, pos);
        
    }
}