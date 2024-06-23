package adapter.list;
import java.util.Collection;

public interface Tuple<T> {
    public T get(int index);
    public int size();
    public boolean isEmpty();
    public boolean contains(Object o);
    public boolean containsAll(Collection<?> c);
    public int indexOf(Object o);
    public int lastIndexOf(Object o);
}