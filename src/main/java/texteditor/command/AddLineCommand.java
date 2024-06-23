package texteditor.command;

import texteditor.TextEditor;

public class AddLineCommand implements Command {
    private String line;
    private int pos;
    private TextEditor textEditor;

    public AddLineCommand(TextEditor editor, int pos, String line) {
        this.textEditor = editor;
        this.line = line;
        this.pos = pos;
    }

    @Override
    public void execute() {
        textEditor.addLine(pos, line);
    }

    @Override
    public void undo() {
        textEditor.deleteLine(pos);
    }
}