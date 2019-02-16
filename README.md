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