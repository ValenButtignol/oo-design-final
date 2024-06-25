package template.immutablelist;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings({"unchecked", "rawtypes"})
public class Main {
    public static void main(String[] args) {
    
        AbstractList<Integer> list1 = new ArrayList<>();
        Collections.addAll(list1, 1, 2, 3, 4, 5);

        AbstractList<Integer> list2 = new LinkedList();
        Collections.addAll(list2, 6, 7, 8, 9, 10);

        Integer[] array = {11, 12, 13, 14, 15};
        AbstractList<Integer> list3 = new ImmutableArrayList(array);

        List<AbstractList<Integer>> listOfAbstractLists = new ArrayList<>();
        listOfAbstractLists.add(list1);
        listOfAbstractLists.add(list2);
        listOfAbstractLists.add(list3);

        List<Integer> maxList = getMaxList(listOfAbstractLists);

        System.out.println("List of max: " + maxList);
    }

    public static <E extends Comparable<E>> List<E> getMaxList(List<AbstractList<E>> listOfAbstractLists) {
        List<E> maxList = new ArrayList<>();
        
        for (AbstractList<E> list : listOfAbstractLists) {
            if (list.isEmpty()) {
                continue;
            }
            
            E maxElement = Collections.max(list);
            maxList.add(maxElement);
        }
        
        return maxList;
    }
}