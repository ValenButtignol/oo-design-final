package texteditor;

import java.util.Scanner;

import texteditor.command.AddLineCommand;
import texteditor.command.AddWordCommand;
import texteditor.command.DeleteLineCommand;
import texteditor.command.DeleteWordCommand;

public class Main {
    public static void main(String[] args) {
        TextEditor buffer = new TextEditor();
        CommandManager commandManager = new CommandManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Line");
            System.out.println("2. Remove Line");
            System.out.println("3. Print Buffer");
            System.out.println("4. Add Word");
            System.out.println("5. Remove Word");
            System.out.println("6. Undo");
            System.out.println("7. Redo");
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
                    System.out.print("Enter line index: ");
                    index = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter word index: ");
                    int wordIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter word: ");
                    String word = scanner.nextLine();
                    commandManager.execute(new AddWordCommand(buffer, index, wordIndex, word));
                    break;
                case 5:
                    System.out.print("Enter line index: ");
                    index = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter word index: ");
                    wordIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    commandManager.execute(new DeleteWordCommand(buffer, index, wordIndex));
                    break;
                case 6:
                    commandManager.undo();
                    break;
                case 7:
                    commandManager.redo();
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
    }
}
