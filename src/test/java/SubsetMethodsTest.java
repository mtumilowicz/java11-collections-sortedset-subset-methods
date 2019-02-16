import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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

    @Test
    public void headSet() {
        SortedSet<Integer> integers = new TreeSet<>(Arrays.asList(1, 2, 3));

        var headSet = integers.headSet(3);

        assertEquals(Set.of(1, 2), headSet);
    }

    @Test
    public void headSet_outOfRange_right() {
        SortedSet<Integer> integers = new TreeSet<>(Arrays.asList(1, 2, 3));

        var headSet = integers.headSet(4);

        assertEquals(Set.of(1, 2, 3), headSet);
    }

    @Test
    public void headSet_outOfRange_left() {
        SortedSet<Integer> integers = new TreeSet<>(Arrays.asList(1, 2, 3));

        var headSet = integers.headSet(0);

        assertThat(headSet, is(empty()));
    }

    @Test
    public void headSet_modify() {
        SortedSet<Integer> integers = new TreeSet<>(Arrays.asList(1, 2, 3));

        var headSet = integers.headSet(5);
        headSet.add(4);

        assertEquals(Set.of(1, 2, 3, 4), headSet);
    }

    @Test(expected = IllegalArgumentException.class)
    public void headSet_modify_outOfRange() {
        SortedSet<Integer> integers = new TreeSet<>(Arrays.asList(1, 2, 3));

        var headSet = integers.headSet(4);
        headSet.add(4);

        assertEquals(Set.of(1, 2, 3, 4), headSet);
    }
}
