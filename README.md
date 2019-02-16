# java11-collections-sortedset-subset-methods

# preface
* `interface SortedSet<E> extends Set<E>`

# subset methods
* `SortedSet<E> subSet(E inclusive, E exclusive)`
    * returns a view of this set - `[inclusive, exclusive)`
    * `IllegalArgumentException` if `fromElement > toElement` or 
      `fromElement` or `toElement` lies outside the bounds of the range of set
    * `NullPointerException` if `fromElement == null` or `toElement == null` and
       this set does not permit nulls
    * `ClassCastException` if `fromElement` and `toElement` are incomparable
        using this set's comparator (or if set does not have it - 
        using natural ordering)
* `SortedSet<E> headSet(E toElement)`
* `SortedSet<E> tailSet(E fromElement)`
* `E first()`
* `E last()`

# project description
We will show basic tests of mentioned above subset methods: