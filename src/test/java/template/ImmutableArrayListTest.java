package template;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import template.immutablelist.ImmutableArrayList;

public class ImmutableArrayListTest {

    @Test
    public void testGet() {
        String[] elements = { "A", "B", "C" };
        List<String> list = new ImmutableArrayList<>(elements);
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    @Test()
    public void testGet_IndexOutOfBounds() {
        String[] elements = { "A", "B", "C" };
        List<String> list = new ImmutableArrayList<>(elements);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
    }

    @Test
    public void testSize() {
        String[] elements = { "A", "B", "C" };
        List<String> list = new ImmutableArrayList<>(elements);
        assertEquals(3, list.size());
    }

    @Test
    public void testContains() {
        String[] elements = { "A", "B", "C" };
        List<String> list = new ImmutableArrayList<>(elements);
        assertTrue(list.contains("A"));
        assertFalse(list.contains("D"));
    }

    @Test
    public void testIndexOf() {
        String[] elements = { "A", "B", "C" };
        List<String> list = new ImmutableArrayList<>(elements);
        assertEquals(0, list.indexOf("A"));
        assertEquals(-1, list.indexOf("D"));
    }

    @Test
    public void testSet() {
        String[] elements = { "A", "B", "C" };
        List<String> list = new ImmutableArrayList<>(elements);
        assertThrows(UnsupportedOperationException.class, () -> list.set(1, "D"));
    }

    @Test()
    public void testAdd() {
        String[] elements = { "A", "B", "C" };
        List<String> list = new ImmutableArrayList<>(elements);
        assertThrows(UnsupportedOperationException.class, () -> list.add("D"));
    }

    @Test()
    public void testRemove() {
        String[] elements = { "A", "B", "C" };
        List<String> list = new ImmutableArrayList<>(elements);
        assertThrows(UnsupportedOperationException.class, () -> list.remove(1));
    }

    @Test
    public void testIsEmpty() {
        String[] elements = {};
        List<String> list = new ImmutableArrayList<>(elements);
        assertTrue(list.isEmpty());
    }

    @Test
    public void testToArray() {
        String[] elements = { "A", "B", "C" };
        List<String> list = new ImmutableArrayList<>(elements);
        Object[] array = list.toArray();
        assertArrayEquals(elements, array);
    }
}