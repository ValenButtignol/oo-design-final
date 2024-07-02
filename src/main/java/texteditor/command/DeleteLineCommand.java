package texteditor.command;

import java.util.List;
import java.util.Scanner;

import texteditor.Buffer;

public class DeleteLineCommand implements Command {

    private int pos;
    private String deletedLine;
    private Buffer buffer;
    Scanner scanner = new Scanner(System.in);

    public DeleteLineCommand(Buffer buffer) {
        this.buffer = buffer;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    @Override
    public void execute() {
        List<String> text = buffer.getBuffer();
        deletedLine = text.remove(pos);
        buffer.setBuffer(text);
    }
    
    @Override
    public void undo() {
        List<String> text = buffer.getBuffer();
        text.add(pos, deletedLine);
        buffer.setBuffer(text);
    }
    
    @Override
    public void scanData() {
        System.out.print("Enter line index: ");
        pos = scanner.nextInt();
    }
}