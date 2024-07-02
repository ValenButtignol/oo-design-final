package texteditor;

import java.util.Scanner;

import texteditor.command.Command;

public class Menu {
    private TextEditor textEditor;
    private Buffer buffer;
    Scanner scanner = new Scanner(System.in);

    public Menu(Buffer buffer) {
        this.textEditor = new TextEditor();
        this.buffer = buffer;
    }

    public void showMenu() {
        System.out.println(textEditor.toString());
        int undoOption = textEditor.getCommands().size();
        int redoOption = textEditor.getCommands().size() + 1;
        int showTextOption = textEditor.getCommands().size() + 2;
        System.out.println(undoOption + ") Undo");
        System.out.println(redoOption + ") Redo");
        System.out.println(showTextOption + ") Show text");
    }

    public void addCommand(Command command) {
        textEditor.addCommand(command);
    }

    public void execute(Integer index) {
        textEditor.execute(index);
    }

    public void undo() {
        textEditor.undo();
    }

    public void redo() {
        textEditor.redo();
    }

    public void showText() {
        System.out.println(buffer.toString());
    }
    
    public void display() {
        System.out.println("Select an option, any other key to exit:");
        
        while (true) {
            showMenu();
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            int commandsSize = textEditor.getCommands().size();
            int undo = commandsSize;
            int redo = commandsSize + 1;
            int showText = commandsSize + 2;
            if (option >= 0 && option < commandsSize) {
                execute(option);
            } else if (option == undo) {
                undo();
            } else if (option == redo) {
                redo();
            } else if (option == showText) {
                showText();
            } else {
                return;
            }
        }
    }
}
