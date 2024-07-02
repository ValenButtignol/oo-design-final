package texteditor.command;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import texteditor.Buffer;

public class AddWordCommand implements Command {
    private int linePos;
    private int wordPos;
    private String word;
    private Buffer buffer;
    Scanner scanner = new Scanner(System.in);

    public AddWordCommand(Buffer buffer) {
        this.buffer = buffer;
    }

    public void setLinePos(int linePos) {
        this.linePos = linePos;
    }

    public void setWordPos(int wordPos) {
        this.wordPos = wordPos;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public void execute() {
        List<String> text = buffer.getBuffer();
        String[] words = text.get(linePos).split(" ");       
        List<String> wordList = new ArrayList<>(List.of(words));
        
        if (wordPos < 0 || wordPos > wordList.size()) 
            throw new IllegalArgumentException("Invalid position");
        
        wordList.add(wordPos, word);
        text.set(linePos, String.join(" ", wordList));
        buffer.setBuffer(text);
    }

    @Override
    public void undo() {
        List<String> text = buffer.getBuffer();
        String[] words = text.get(linePos).split(" ");
        List<String> wordList = new ArrayList<>(List.of(words));
        
        if (wordPos < 0 || wordPos >= wordList.size()) 
            throw new IllegalArgumentException("Invalid position");
    
        wordList.remove(wordPos);
        text.set(linePos, String.join(" ", wordList));
    }

    @Override
    public void scanData() {
        System.out.print("Enter line index: ");
        linePos = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter word index: ");
        wordPos = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter word: ");
        word = scanner.nextLine();   
    }
}