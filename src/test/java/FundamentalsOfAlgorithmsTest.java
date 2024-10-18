import exception.IndexOutOfBoundException;
import exception.NullItemException;
import model.FundamentalsOfAlgorithms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FundamentalsOfAlgorithmsTest {

    private FundamentalsOfAlgorithms list;

    @BeforeEach
    public void setUp() {
        list = new FundamentalsOfAlgorithms(5);
    }

    @Test
    public void testAddItem() {
        assertEquals("тест", list.add("тест"));
        assertEquals(1, list.size());
        assertThrows(NullItemException.class, () -> list.add(null));
    }

    @Test
    public void testAddByIndex() {
        list.add("item1");
        list.add("item2");
        list.add(1, "item3");
        assertEquals("item3", list.get(1));
        assertEquals(3, list.size());
    }

    @Test
    public void testSet() {
        list.add("item1");
        list.add("item2");
        assertEquals("item2", list.set(1, "item3"));
        assertEquals("item3", list.get(1));
    }

    @Test
    public void testRemoveByItem() {
        list.add("item1");
        list.add("item2");
        assertEquals("item2", list.remove(1));
        assertEquals(1, list.size());
        assertThrows(NullItemException.class, () -> list.remove(null));
    }

    @Test
    public void testRemoveByIndex() {
        list.add("item1");
        list.add("item2");
        assertEquals("item2", list.remove(1));
        assertEquals(1, list.size());
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(2));
    }

    @Test
    public void testContains() {
        list.add("item1");
        list.add("item2");
        assertTrue(list.contains("item1"));
        assertFalse(list.contains("item3"));
    }

    @Test
    public void testIndexOf() {
        list.add("item1");
        list.add("item2");
        assertEquals(0, list.indexOf("item1"));
        assertEquals(-1, list.indexOf("item3"));
    }

    @Test
    public void testLastIndexOf() {
        list.add("item1");
        list.add("item2");
        list.add("item1");
        assertEquals(2, list.lastIndexOf("item1"));
    }

    @Test
    public void testGet() {
        list.add("item1");
        list.add("item2");
        assertEquals("item2", list.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
    }

    @Test
    public void testEquals() {
        FundamentalsOfAlgorithms anotherList = new FundamentalsOfAlgorithms(5);
        list.add("item1");
        anotherList.add("item1");
        assertTrue(list.equals(anotherList));
    }

    @Test
    public void testSize() {
        list.add("item1");
        list.add("item2");
        assertEquals(2, list.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add("item1");
        assertFalse(list.isEmpty());
    }

    @Test
    public void testClear() {
        list.add("item1");
        list.add("item2");
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testToArray() {
        list.add("item1");
        list.add("item2");
        String[] array = list.toArray();
        assertEquals(2, array.length);
        assertEquals("item1", array[0]);
        assertEquals("item2", array[1]);
    }

}

