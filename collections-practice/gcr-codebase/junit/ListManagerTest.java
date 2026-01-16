import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;
public class ListManagerTest {

    // Add element to list
    static void add(List<Integer> list, int element) {
        list.add(element);
    }

    // Remove element from list
    static void remove(List<Integer> list, int element) {
        list.remove(Integer.valueOf(element));
    }

    // Return size of list
    static int get(List<Integer> list) {
        return list.size();
    }

    @Test
    void testAdd() {
        List<Integer> list = new ArrayList<>();
        addElement(list, 5);
        assertTrue(list.contains(5));
    }

    @Test
    void testRemove() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        removeElement(list, 10);
        assertFalse(list.contains(10));
    }

    @Test
    void testSize() {
        List<Integer> list = new ArrayList<>();
        addElement(list, 1);
        addElement(list, 2);
        assertEquals(2, getSize(list));
    }
}

