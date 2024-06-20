package fizzbuzz.output;

public class MockOutput implements Output {

    private boolean invoked = false;
    private String printInput;
    
    @Override
    public void print(String toPrint) {
        invoked = true;
        printInput = toPrint;
    }

    public boolean printIsInvoked() {
        return invoked;
    }

    public String getPrintInput() {
        return printInput;
    }
}