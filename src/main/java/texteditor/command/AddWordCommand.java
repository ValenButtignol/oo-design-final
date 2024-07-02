package texteditor.command;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import texteditor.Buffer;
import texteditor.TextEditor;

public class AddWordCommand implements Command {
    private int linePos;
    private int wordPos;
    private String word;
    private Buffer buffer;
    Scanner scanner = new Scanner(System.in);

    public AddWordCommand(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void execute() {
        List<String> text = buffer.getBuffer();
        String[] words = text.get(linePos).split(" ");       
        List<String> wordList = new ArrayList<>(List.of(words));
        
        if (pos < 0 || pos > wordList.size()) 
            throw new IllegalArgumentException("Invalid position");
        
        wordList.add(pos, word);
        text.set(linePos, String.join(" ", wordList));
        buffer.setBuffer(text);
    }

    @Override
    public void undo() {
        scanPosLineAndWord();
        
        editor.deleteWord(linePos, pos);
        

        List<String> text = buffer.getBuffer();
        String[] words = buffer.get(linePos).split(" ");
        List<String> wordList = new ArrayList<>(List.of(words));
        
        if (pos < 0 || pos >= wordList.size()) 
            throw new IllegalArgumentException("Invalid position");
    
        String removedWord = wordList.remove(pos);
        buffer.set(linePos, String.join(" ", wordList));
        return removedWord;
    }

    private void scanPosLineAndWord() {
        System.out.print("Enter line index: ");
        int linePos = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter word index: ");
        int wordPos = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter word: ");
        String word = scanner.nextLine();
        
        this.linePos = linePos;
        this.wordPos = wordPos;
        this.word = word;
    }
}