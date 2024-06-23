package adapter.list;
import java.util.Collection;
import java.util.Objects;

public class ImmutableTuple <T> implements Tuple<T> {
    private T[] elements;

    @SafeVarargs
    public ImmutableTuple(T... elements) {
        this.elements = elements;
    }

    public T get(int index) {
        if (index < 0 || index >= elements.length) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return elements[index];
    }

    public int size() {
        return elements.length;
    }

    public boolean isEmpty() {
        return elements.length == 0;
    }

    public boolean contains(Object o) {
        for (T element : elements) {
            if (Objects.equals(element, o)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < elements.length; i++) {
            if (Objects.equals(elements[i], o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = elements.length - 1; i >= 0; i--) {
            if (Objects.equals(elements[i], o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String res = "(";
        for (int i = 0; i < elements.length - 1; i++) {
            res += elements[i].toString() + ", ";
        }
        res += elements[elements.length - 1] + ")";
        return res;
    }
}