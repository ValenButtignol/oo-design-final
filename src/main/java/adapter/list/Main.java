package adapter.list;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> adapter = new TupleAdapter<Integer>(new ImmutableTuple<>(1,2,3,4));

        System.out.println(adapter.toString());
    }
}