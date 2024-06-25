package adapter.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ImmutableTuple<Integer> immutableTuple = new ImmutableArrayTuple<>(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5);
        
        List<Integer> immutableList = new TupleAdapter<>(immutableTuple);
        
        List<Integer> mutableList = new ArrayList<>(Arrays.asList(8, 3, 7, 0, 2, 4, 6));
        
        System.out.println("Maximum value in immutableList: " + findMax(immutableList));
        System.out.println("Maximum value in mutableList: " + findMax(mutableList));
        
        List<Integer> subImmutableList = immutableList.subList(3, 8);
        System.out.println("Sublist from immutableList: " + subImmutableList);
        System.out.println("Maximum value in subImmutableList: " + findMax(subImmutableList));
        
        List<Integer> combinedList = new ArrayList<>(immutableList);
        combinedList.addAll(mutableList);
        System.out.println("Combined list: " + combinedList);
        
        System.out.println("Maximum value in combinedList: " + findMax(combinedList));
    }
    
    private static <T extends Comparable<T>> T findMax(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
        T max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(max) > 0) {
                max = list.get(i);
            }
        }
        return max;
    }
}
