package adapter.list;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ImmutableTuple<Integer> tupleList = new ImmutableTuple<Integer>(1,2,3,4);

        System.out.println(tupleList.toString());

    }
}
