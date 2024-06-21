package adventuregame.displays;

import java.util.ArrayList;
import java.util.List;

public class MockDisplayElement extends DisplayElement {

    private List<String> displayList;
    
    public MockDisplayElement() {
        super();
        displayList = new ArrayList<>();
    }

    @Override
    public void display(String str) {
        displayList.add(str);
    }

    public List<String> getDisplayList() {
        return displayList;
    }
}
