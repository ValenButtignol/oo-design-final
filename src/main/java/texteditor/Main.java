package texteditor;

import java.util.Scanner;

import texteditor.command.AddLineCommand;
import texteditor.command.DeleteLineCommand;

public class Main {
    public static void main(String[] args) {
        TextEditor buffer = new TextEditor();
        CommandManager commandManager = new CommandManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Line");
            System.out.println("2. Remove Line");
            System.out.println("3. Print Buffer");
            System.out.println("4. Undo");
            System.out.println("5. Redo");
            System.out.print("Enter command: ");
            int command = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (command) {
                case 1:
                    System.out.print("Enter line index: ");
                    int index = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter line text: ");
                    String line = scanner.nextLine();
                    commandManager.execute(new AddLineCommand(buffer, index, line));
                    break;
                case 2:
                    System.out.print("Enter line index: ");
                    index = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    commandManager.execute(new DeleteLineCommand(buffer, index));
                    break;
                case 3:
                    buffer.print();
                    break;
                case 4:
                    commandManager.undo();
                    break;
                case 5:
                    commandManager.redo();
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
    }
}
