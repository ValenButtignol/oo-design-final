package output;

public class Terminal implements Output {
    @Override
    public void print(String toPrint) {
        System.out.println(toPrint);
    }
}