package pl.melafin.kata.tree;

/**
 * Tree should accept any String. Strings may be separated using a slash "/". In that case strings should be split and put into separated nodes,
 * where the first string should be a parent, and consecutive strings should be in relation child-parent.
 *
 * Example: string "A/B/C"
 *
 *      A
 *      |
 *      B
 *      |
 *      C
 *
 * Now we add String "A/B/Whatever":
 *
 *      A
 *      |
 *      B
 *     /\
 *    C Whatever
 *
 *  Anyway, there should always be a root with value ROOT, so the whole tree from previous example should look like this:
 *
 *      ROOT
 *       |
 *       A
 *       |
 *       B
 *      /\
 *     C  Whatever
 *
 * However, ROOT shouldn't count when it comes to compute tree size or isEmpty method. Should be impossible to iterate through a ROOT value.
 *
 * Tree should not accept nulls or blank strings.
 */
public interface MultiTree extends Iterable<String>{

    void add(String element);

    /**
     * Cannot remove ROOT!
     * @return removed element. If no element was removed, return null
     */
    String remove(String element);

    /**
     * Search for ROOT always returns false!
     */
    boolean contains(String element);

    /**
     * ROOT doesn't count
     */
    int size();

    /**
     * ROOT doesn't count
     */
    boolean isEmpty();

    /**
     * Tree with only ROOT should have depth of 0
     */
    int depth();

    /**
     * Tree with only ROOT should have breadth of 0
     */
    int breadth();
}
