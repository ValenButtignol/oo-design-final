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
        scanPosAndLine();
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
    
    private void scanPosAndLine() {
        System.out.print("Enter line index: ");
        int pos = scanner.nextInt();
        this.pos = pos;
        scanner.nextLine(); // Consume newline
        System.out.print("Enter line text: ");
        String line = scanner.nextLine();
        this.line = line;
    }
}