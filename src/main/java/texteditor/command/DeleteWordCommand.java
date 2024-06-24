package texteditor.command;

import texteditor.TextEditor;

public class DeleteWordCommand implements Command {
    private int linePos;
    private int pos;
    private String word;
    private TextEditor editor;
    
    public DeleteWordCommand(TextEditor editor, int linePos, int pos) {
        this.linePos = linePos;
        this.pos = pos;
        this.editor = editor;
    }

    @Override
    public void execute() {
        word = editor.deleteWord(linePos, pos);
    }

    @Override
    public void undo() {
        editor.addWord(linePos, pos, word);
    }
}