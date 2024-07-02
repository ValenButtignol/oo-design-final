package texteditor.command;

import java.util.List;
import java.util.Scanner;

import texteditor.Buffer;

public class AddLineCommand implements Command {
    private String line;
    private int pos;
    private Buffer buffer;
    Scanner scanner = new Scanner(System.in);

    public AddLineCommand(Buffer buffer) {
        this.buffer = buffer;
    }
    
    @Override
    public void execute() {
        List<String> text = buffer.getBuffer();
        text.add(pos, line);
        buffer.setBuffer(text);
    }
    
    @Override
    public void undo() {
        List<String> text = buffer.getBuffer();
        text.remove(pos);
        buffer.setBuffer(text);
    }
    
    @Override
    public void scanData() {
        System.out.print("Enter line index: ");
        pos = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter line text: ");
        line = scanner.nextLine();
    }

    public void setLine(String line) {
        this.line = line;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    @Override
    public Command copy() {
        AddLineCommand copy = new AddLineCommand(buffer);
        copy.setLine(line);        
        copy.setPos(pos);
        return copy;
    }
}