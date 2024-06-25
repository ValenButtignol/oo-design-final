package template.immutablelist;

import java.util.AbstractList;
import java.util.Collection;

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

    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException("Unsupported operation by Immutable Array List");
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("Immutable list");
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Immutable list");
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Immutable list");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Unsupported operation by Immutable Array List");
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException("Unsupported operation by Immutable Array List");
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Unsupported operation by Immutable Array List");
    }
}