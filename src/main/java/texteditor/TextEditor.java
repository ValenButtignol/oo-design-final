package texteditor;

import java.util.ArrayList;
import java.util.List;

public class TextEditor {
    List<String> buffer;
    
    public TextEditor() {
        buffer = new ArrayList<>();
    }

    public void addLine(int pos, String line) {
        buffer.add(pos, line);
    }
    
    public String deleteLine(int pos) {
        return buffer.remove(pos);
    }

    public void print() {
        for (String line : buffer) {
            System.out.println(line);
        }
    }

    public List<String> getBuffer() {
        return buffer;
    }
}