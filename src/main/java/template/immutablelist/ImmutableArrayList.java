package template.immutablelist;

import java.util.AbstractList;

public class ImmutableArrayList<E> extends AbstractList<E> {
    private final E[] elements;

    public ImmutableArrayList(E[] elements) {
        this.elements = elements.clone();
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= elements.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        return elements[index];
    }

    @Override
    public int size() {
        return elements.length;
    }
}