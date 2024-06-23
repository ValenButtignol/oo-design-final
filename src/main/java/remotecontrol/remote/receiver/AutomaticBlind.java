package remotecontrol.remote.receiver;

public class AutomaticBlind {
    private String location = "";
    public static final Integer MAX_HEIGHT = 2;
    public static final Integer MEDIUM_HEIGHT = 1;
    public static final Integer MIN_HEIGHT = 0;
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