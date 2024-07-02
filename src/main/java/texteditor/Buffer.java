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

    //////////////////
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

    public void addWord(int linePos, int pos, String word) {
        String[] words = buffer.get(linePos).split(" ");
        List<String> wordList = new ArrayList<>(List.of(words));

        if (pos < 0 || pos > wordList.size()) 
            throw new IllegalArgumentException("Invalid position");

        wordList.add(pos, word);
        buffer.set(linePos, String.join(" ", wordList));
    }

    public String deleteWord(int linePos, int pos) {
        String[] words = buffer.get(linePos).split(" ");
        List<String> wordList = new ArrayList<>(List.of(words));
        
        if (pos < 0 || pos >= wordList.size()) 
            throw new IllegalArgumentException("Invalid position");
    
        String removedWord = wordList.remove(pos);
        buffer.set(linePos, String.join(" ", wordList));
        return removedWord;
    }
}