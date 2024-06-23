package texteditor.command;

import texteditor.TextEditor;

public class DeleteLineCommand implements Command {

    private int pos;
    private TextEditor textEditor;
    private String deletedLine;

    public DeleteLineCommand(TextEditor editor, int pos) {
        this.pos = pos;
        this.textEditor = editor;
    }

    @Override
    public void execute() {
        deletedLine = textEditor.deleteLine(pos);
    }

    @Override
    public void undo() {
        textEditor.addLine(pos, deletedLine);
    }
}