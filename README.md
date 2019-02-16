# java11-collections-sortedset-subset-methods

# preface
* `interface SortedSet<E> extends Set<E>`
* `TreeSet<E> implements SortedSet<E>`
* the implementation class for `SortedSet` should have a constructor accepting `Comparator`
* if no comparator is specified it should use natural ordering (`compareTo()`
    method of elements to sort them)
* if a class does not implements `Comparable` and we will not specify `Comparator` then `ClassCastException` while 
attempting to add element
* handling null:
    * `NullPointerException` in case of natural order
    * depends on `Comparator`

# subset methods
* `SortedSet<E> subSet(E inclusive, E exclusive)`
    * returns a view of this set - `[inclusive, exclusive)`
    * changes in the returned set are reflected in this set, and vice-versa
    * `IllegalArgumentException` 
        * if `fromElement > toElement`
        * on an attempt to insert an element outside its range
    * `ClassCastException` if `E` does not implement `Comparable` and we don't specify set's `Comparator`
* `SortedSet<E> headSet(E exclusive)`
    * returns a view of this set - `[beginning, exclusive)`
    * changes in the returned set are reflected in this set, and vice-versa
    * `IllegalArgumentException` - on an attempt to insert an element outside its range
    * `ClassCastException` if `E` does not implement `Comparable` and we don't specify set's `Comparator`
* `SortedSet<E> tailSet(E inclusive)`
    * similar to `headSet`
* `E first()`
* `E last()`

# project description
We will show basic tests of mentioned above subset methods:
1. subset
    * get subset
        ```
        SortedSet<Integer> integers = new TreeSet<>(Arrays.asList(1, 2, 3));
        
        var subset = integers.subSet(0, 20);
        
        assertEquals(Set.of(1, 2, 3), subset);
        ```
    * if we modify the subset the source is modified as well
        ```
        SortedSet<Integer> integers = new TreeSet<>(Arrays.asList(1, 2, 3));
        
        var subset = integers.subSet(2, 5);
        subset.add(4);
        
        assertEquals(Set.of(2, 3, 4), subset);
        assertEquals(Set.of(1, 2, 3, 4), integers);
        ```
    * if we modify the source the subset is modified as well
        ```
        SortedSet<Integer> integers = new TreeSet<>(Arrays.asList(1, 2, 3));
        
        var subset = integers.subSet(2, 5);
        integers.add(4);
        
        assertEquals(Set.of(2, 3, 4), subset);
        assertEquals(Set.of(1, 2, 3, 4), integers);
        ```
    * inserting out of range will throw `IllegalArgumentException`
        ```
        @Test(expected = IllegalArgumentException.class)
        public void subset_modify_outOfRange() {
            SortedSet<Integer> integers = new TreeSet<>(Arrays.asList(1, 2, 3));
        
            var subset = integers.subSet(2, 4);
            subset.add(4);
        }
        ```
1. headSet
    * create headSet
        ```
        SortedSet<Integer> integers = new TreeSet<>(Arrays.asList(1, 2, 3));
        
        var headSet = integers.headSet(3);
        
        assertEquals(Set.of(1, 2), headSet);
        ```
    * toElement > range
        ```
        SortedSet<Integer> integers = new TreeSet<>(Arrays.asList(1, 2, 3));

        var headSet = integers.headSet(4);

        assertEquals(Set.of(1, 2, 3), headSet);
        ```
    * toElement < beginning
        ```
        SortedSet<Integer> integers = new TreeSet<>(Arrays.asList(1, 2, 3));

        var headSet = integers.headSet(0);

        assertThat(headSet, is(empty()));
        ```
    * if we modify the headSet the source is also modified
        ```
        SortedSet<Integer> integers = new TreeSet<>(Arrays.asList(1, 3));

        var headSet = integers.headSet(3);
        headSet.add(2);

        assertEquals(Set.of(1, 2, 3), headSet);
        assertEquals(Set.of(1, 2, 3), integers);
        ```
    * if we modify the source the headSet is also modified
        ```
        SortedSet<Integer> integers = new TreeSet<>(Arrays.asList(1, 3));

        var headSet = integers.headSet(3);
        integers.add(2);

        assertEquals(Set.of(1, 2, 3), headSet);
        assertEquals(Set.of(1, 2, 3), integers);        
        ```
    * inserting out of range will throw `IllegalArgumentException`
        ```
        @Test(expected = IllegalArgumentException.class)
        public void headSet_modify_outOfRange() {
            SortedSet<Integer> integers = new TreeSet<>(Arrays.asList(1, 2, 3));
        
            var headSet = integers.headSet(4);
            headSet.add(4);
        }
        ```
1. tailSet - similar to headSet
1. first / last
    ```
    assertThat(new TreeSet<>(Arrays.asList(1, 2, 3)).first(), is(1));
    ```
    ```
    assertThat(new TreeSet<>(Arrays.asList(1, 2, 3)).last(), is(3));
    ```