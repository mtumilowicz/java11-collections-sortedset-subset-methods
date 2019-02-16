# java11-collections-sortedset-subset-methods

# preface
* `interface SortedSet<E> extends Set<E>`
* `TreeSet<E> implements SortedSet<E>`
* the implementation class for `SortedSet` should have a constructor accepting `Comparator`
* if no comparator is specified it should use natural ordering (`compareTo()`
    method of elements to sort them)
* if a class does not implements Comparable and we will not specify `Comparator` then `ClassCastException` while 
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
        * `fromElement` or `toElement` lies outside the bounds of the range of set
        * on an attempt to insert an element outside its range
    * `NullPointerException` if `fromElement == null` or `toElement == null` and
       this set does not permit nulls
    * `ClassCastException` if `fromElement` and `toElement` are incomparable
        using this set's comparator (or if set does not have it - 
        using natural ordering)
* `SortedSet<E> headSet(E exclusive)`
    * returns a view of this set - `[beginning, exclusive)`
    * changes in the returned set are reflected in this set, and vice-versa
    * `IllegalArgumentException` if this set itself has a restricted range, and `toElement` lies outside the
      bounds of the range
    * `NullPointerException` if `toElement` is null and this set does not permit null elements
    * `ClassCastException` if `toElement` is incomparable
        using this set's comparator (or if set does not have it - 
        using natural ordering)
* `SortedSet<E> tailSet(E inclusive)`
    * similar to `headSet`
* `E first()`
* `E last()`

# project description
We will show basic tests of mentioned above subset methods: