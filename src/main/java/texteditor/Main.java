package texteditor;

import texteditor.command.AddLineCommand;
import texteditor.command.AddWordCommand;
import texteditor.command.Command;
import texteditor.command.DeleteLineCommand;
import texteditor.command.DeleteWordCommand;

public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Menu menu = new Menu(buffer);

        Command addLineCommand = new AddLineCommand(buffer);
        menu.addCommand(addLineCommand);
        Command deleteLineCommand = new DeleteLineCommand(buffer);
        menu.addCommand(deleteLineCommand);
        Command addWordCommand = new AddWordCommand(buffer);
        menu.addCommand(addWordCommand);
        Command deleteWordCommand = new DeleteWordCommand(buffer);
        menu.addCommand(deleteWordCommand);

        menu.display();        
    }
}