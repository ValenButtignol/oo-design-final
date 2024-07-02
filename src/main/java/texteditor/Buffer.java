package texteditor;

import java.util.ArrayList;
import java.util.List;

public class Buffer {
    List<String> buffer;
    
    public Buffer() {
        buffer = new ArrayList<>();
    }

    public void setBuffer(List<String> buffer) {
        this.buffer = buffer;
    }

    public List<String> getBuffer() {
        return buffer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String line : buffer) {
            sb.append(line).append("\n");
        }
        return sb.toString();
    }
}