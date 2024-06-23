package remotecontrol.remotewithundo.receiver;

public class AutomaticBlind {
    private String location = "";
    private final Integer MAX_HEIGHT = 2;
    private final Integer MEDIUM_HEIGHT = 1;
    private final Integer MIN_HEIGHT = 0;
    private Integer height;

    public AutomaticBlind(String location) {
        this.location = location;
    }

    public void maxHeight() {
        height = MAX_HEIGHT;
        System.out.println(location + " blinds are completely up");
    }

    public void mediumHeight() {
        height = MEDIUM_HEIGHT;
        System.out.println(location + " blinds are half up");
    }

    public void minHeight() {
        height = MIN_HEIGHT;
        System.out.println(location + " blinds are closed");
    }   
    
    public Integer getHeight() {
        return height;
    }
}