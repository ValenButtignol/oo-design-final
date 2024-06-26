package adapter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import adapter.list.ImmutableArrayTuple;
import adapter.list.ImmutableTuple;
import adapter.list.TupleAdapter;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class TestTupleAdapter {
    private ImmutableTuple<Integer> tuple;
    private static List<Integer> adapter;

    @BeforeEach
    public void setUp() {
        tuple = new ImmutableArrayTuple<>(1, 2, 3);
        adapter = new TupleAdapter<>(tuple);
    }

    @Test
    public void testGet() {
        assertEquals(1, adapter.get(0));
        assertEquals(2, adapter.get(1));
        assertEquals(3, adapter.get(2));
    }

    @Test
    public void testSize() {
        assertEquals(3, adapter.size());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(adapter.isEmpty());
    }

    @Test
    public void testContains() {
        assertTrue(adapter.contains(2));
        assertFalse(adapter.contains(4));
    }

    @Test
    public void testIndexOf() {
        assertEquals(1, adapter.indexOf(2));
        assertEquals(-1, adapter.indexOf(4));
    }

    @Test
    public void testLastIndexOf() {
        assertEquals(1, adapter.lastIndexOf(2));
        assertEquals(-1, adapter.lastIndexOf(4));
    }

    @Test
    public void testContainsAll() {
        assertTrue(adapter.containsAll(List.of(1, 2))); 
        assertFalse(adapter.containsAll(List.of(1, 4)));
    }

    @Test
    public void testToArray() {
        assertArrayEquals(new Integer[]{1, 2, 3}, adapter.toArray());
    }

    @Test
    public void testToArrayWithParameter() {
        Integer[] array = new Integer[3];
        assertArrayEquals(new Integer[]{1, 2, 3}, adapter.toArray(array));
    }

    @Test
    public void testSubTuple() {
        List<Integer> subTuple = adapter.subList(1, 3);
        assertEquals(2, subTuple.size());
        assertEquals(2, subTuple.get(0));
        assertEquals(3, subTuple.get(1));
    }

    private static List<Executable> unsupportedMethodsProvider() {
        return List.of(
                () -> adapter.iterator(),
                () -> adapter.add(4),
                () -> adapter.remove(Integer.valueOf(2)),
                () -> adapter.addAll(List.of(4, 5)),
                () -> adapter.addAll(0, List.of(4, 5)),
                () -> adapter.removeAll(List.of(2, 3)),
                () -> adapter.retainAll(List.of(1, 2)),
                () -> adapter.clear(),
                () -> adapter.set(0, 5),
                () -> adapter.add(0, 5),
                () -> adapter.remove(0),
                () -> adapter.listIterator(),
                () -> adapter.listIterator(1)
        );
    }

    @ParameterizedTest
    @MethodSource("unsupportedMethodsProvider")
    public void testUnsupportedOperations(Executable executable) {
        assertThrows(UnsupportedOperationException.class, executable);
    }
}