import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

/**
 * Created by mtumilowicz on 2019-02-16.
 */
public class SubsetMethodsTest {
    
    @Test
    public void subset() {
        SortedSet<Integer> integers = new TreeSet<>(Arrays.asList(1, 2, 3));

        var subset = integers.subSet(2, 6);
        
        assertEquals(Set.of(2, 3), subset);
    }
    
    @Test
    public void subset_outOfRange() {
        SortedSet<Integer> integers = new TreeSet<>(Arrays.asList(1, 2, 3));

        var subset = integers.subSet(0, 20);

        assertEquals(Set.of(1, 2, 3), subset);
    }
    
    @Test
    public void subset_modify() {
        SortedSet<Integer> integers = new TreeSet<>(Arrays.asList(1, 2, 3));

        var subset = integers.subSet(2, 5);
        subset.add(4);
        
        assertEquals(Set.of(2, 3, 4), subset);
        assertEquals(Set.of(1, 2, 3, 4), integers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void subset_modify_outOfRange() {
        SortedSet<Integer> integers = new TreeSet<>(Arrays.asList(1, 2, 3));

        var subset = integers.subSet(2, 4);
        subset.add(4);
    }
}
