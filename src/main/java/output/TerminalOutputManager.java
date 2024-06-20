package output;

public class TerminalOutputManager implements OutputManager {
    @Override
    public void print(String toPrint) {
        System.out.println(toPrint);
    }
}