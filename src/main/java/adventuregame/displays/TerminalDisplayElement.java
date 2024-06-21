package adventuregame.displays;

public class TerminalDisplayElement extends DisplayElement {
    
    public TerminalDisplayElement() {
        super();
    }

    @Override
    public void display(String str) {
        System.out.println(str);
    }
}
