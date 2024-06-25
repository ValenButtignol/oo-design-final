package adapter.list;
import java.util.Collection;

public interface ImmutableTuple<T> {
    int size();                      
    T get(int index);                
    boolean contains(Object element);      
    int indexOf(Object element);           
    int lastIndexOf(Object element);       
    ImmutableTuple<T> subTuple(int fromIndex, int toIndex);
    boolean containsAll(Collection<?> c); 
    boolean isEmpty();               
    Object[] toArray();               
    <E> E[] toArray(E[] a);           
}