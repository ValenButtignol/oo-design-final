package adapter.list;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TupleAdapter<T> implements List<T> {

    private ImmutableTuple<T> tuple;

    public TupleAdapter(ImmutableTuple<T> tuple) {
        this.tuple = tuple;
    }

    @Override
    public int size() {
        return tuple.size();
    }

    @Override
    public boolean isEmpty() {
        return tuple.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return tuple.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Immutable Tuple does not support iterator method");
    }

    @Override
    public Object[] toArray() {
        return tuple.toArray();
    }

    @Override
    public <E> E[] toArray(E[] a) {
        return tuple.toArray(a);
    }

    @Override
    public boolean add(T e) {
        throw new UnsupportedOperationException("Immutable Tuple does not support add method");
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Immutable Tuple does not support remove method");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return tuple.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException("Immutable Tuple does not support addAll method");
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException("Immutable Tuple does not support addAll method");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Immutable Tuple does not support removeAll method");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Immutable Tuple does not support retainAll method");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Immutable Tuple does not support clear method");
    }

    @Override
    public T get(int index) {
        return tuple.get(index);
    }

    @Override
    public T set(int index, T element) {
        throw new UnsupportedOperationException("Immutable Tuple does not support set method");
    }

    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException("Immutable Tuple does not support add method");
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException("Immutable Tuple does not support remove method");
    }

    @Override
    public int indexOf(Object o) {
        return tuple.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return tuple.lastIndexOf(o);
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("Immutable Tuple does not support listIterator method");
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("Immutable Tuple does not support listIterator method");
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > tuple.size() || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("FromIndex: " + fromIndex + ", ToIndex: " + toIndex + ", Size: " + tuple.size());
        }
        ImmutableTuple<T> subTuple = tuple.subTuple(fromIndex, toIndex);
        return new TupleAdapter<>(subTuple);
    }

    @Override
    public String toString() {
        return tuple.toString();
    }
}