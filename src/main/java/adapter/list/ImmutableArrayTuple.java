package adapter.list;

import java.util.Arrays;
import java.util.Collection;

public class ImmutableArrayTuple<T> implements ImmutableTuple<T> {
    private final T[] elements;

    @SafeVarargs
    public ImmutableArrayTuple(T... elements) {
        this.elements = Arrays.copyOf(elements, elements.length);
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= elements.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + elements.length);
        }
        return elements[index];
    }

    @Override
    public boolean contains(Object element) {
        return indexOf(element) >= 0;
    }

    @Override
    public int indexOf(Object element) {
        for (int i = 0; i < elements.length; i++) {
            if ((element == null && elements[i] == null) || (element != null && element.equals(elements[i]))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object element) {
        for (int i = elements.length - 1; i >= 0; i--) {
            if ((element == null && elements[i] == null) || (element != null && element.equals(elements[i]))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ImmutableTuple<T> subTuple(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > elements.length || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("FromIndex: " + fromIndex + ", ToIndex: " + toIndex + ", Size: " + elements.length);
        }
        return new ImmutableArrayTuple<>(Arrays.copyOfRange(elements, fromIndex, toIndex));
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return elements.length == 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, elements.length);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E> E[] toArray(E[] a) {
        if (a.length < elements.length) {
            return (E[]) Arrays.copyOf(elements, elements.length, a.getClass());
        }
        System.arraycopy(elements, 0, a, 0, elements.length);
        if (a.length > elements.length) {
            a[elements.length] = null;
        }
        return a;
    }

    @Override
    public String toString() {
        String result = "(";
        for (int i = 0; i < elements.length; i++) {
            result += elements[i];
            if (i < elements.length - 1) {
                result += ", ";
            }
        }
        result += ")";
        return result;
    }
}
