package adapter;

import adapter.list.ImmutableArrayTuple;
import adapter.list.ImmutableTuple;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class TestImmutableArrayTuple {

    @Test
    public void testSize() {
        ImmutableTuple<Integer> tuple = new ImmutableArrayTuple<>(1, 2, 3);
        assertEquals(3, tuple.size());
    }

    @Test
    public void testGet() {
        ImmutableTuple<String> tuple = new ImmutableArrayTuple<>("a", "b", "c");
        assertEquals("a", tuple.get(0));
        assertEquals("b", tuple.get(1));
        assertEquals("c", tuple.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> tuple.get(3));
    }

    @Test
    public void testContains() {
        ImmutableTuple<Integer> tuple = new ImmutableArrayTuple<>(1, 2, 3);
        assertTrue(tuple.contains(1));
        assertFalse(tuple.contains(4));
    }

    @Test
    public void testIndexOf() {
        ImmutableTuple<Integer> tuple = new ImmutableArrayTuple<>(1, 2, 3, 2);
        assertEquals(1, tuple.indexOf(2));
        assertEquals(-1, tuple.indexOf(4));
    }

    @Test
    public void testLastIndexOf() {
        ImmutableTuple<Integer> tuple = new ImmutableArrayTuple<>(1, 2, 3, 2);
        assertEquals(3, tuple.lastIndexOf(2));
        assertEquals(-1, tuple.lastIndexOf(4));
    }

    @Test
    public void testSubTuple() {
        ImmutableTuple<Integer> tuple = new ImmutableArrayTuple<>(1, 2, 3, 4, 5);
        ImmutableTuple<Integer> subTuple = tuple.subTuple(1, 4);
        assertEquals(3, subTuple.size());
        assertEquals(2, subTuple.get(0));
        assertEquals(4, subTuple.get(2));
    }

    @Test
    public void testContainsAll() {
        ImmutableTuple<Integer> tuple = new ImmutableArrayTuple<>(1, 2, 3, 4, 5);
        assertTrue(tuple.containsAll(Arrays.asList(1, 2, 3)));
        assertFalse(tuple.containsAll(Arrays.asList(1, 2, 6)));
    }

    @Test
    public void testIsEmpty() {
        ImmutableTuple<Integer> emptyTuple = new ImmutableArrayTuple<>();
        ImmutableTuple<Integer> nonEmptyTuple = new ImmutableArrayTuple<>(1, 2, 3);
        assertTrue(emptyTuple.isEmpty());
        assertFalse(nonEmptyTuple.isEmpty());
    }

    @Test
    public void testToArray() {
        ImmutableTuple<Integer> tuple = new ImmutableArrayTuple<>(1, 2, 3);
        Object[] array = tuple.toArray();
        assertArrayEquals(new Object[]{1, 2, 3}, array);
    }

    @Test
    public void testToArrayWithType() {
        ImmutableTuple<Integer> tuple = new ImmutableArrayTuple<>(1, 2, 3);
        Integer[] array = tuple.toArray(new Integer[0]);
        assertArrayEquals(new Integer[]{1, 2, 3}, array);
    }
}