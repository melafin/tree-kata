package pl.melafin.kata.tree.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.melafin.kata.tree.MultiTree;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MultiTreeImplTest {

    private MultiTree tree;

    @BeforeEach
    public void setup() {
        tree = new MultiTreeImpl();
    }

    @Test
    @DisplayName("Asked if tree contains ROOT - false")
    public void containsRootTest() {
        //  GIVEN : no added elements

        //  WHEN
        boolean result = tree.contains("ROOT");

        //  THEN
        assertThat(result, equalTo(false));
    }

    @Test
    @DisplayName("There is a tree with no elements added. Should have size of 0, be empty, and have breadth and depth of 0")
    public void emptyTreeTest() {
        //  GIVEN : no added elements

        //  EXPECT
        assertThat(tree.isEmpty(), equalTo(true));
        assertThat(tree.size(), equalTo(0));
        assertThat(tree.depth(), equalTo(0));
        assertThat(tree.breadth(), equalTo(0));
    }

    @Test
    @DisplayName("Added one simple element. Size 1, empty false, depth and breadth of 1. Should find the string in the tree.")
    public void simpleElementTest() {
        //  GIVEN
        tree.add("simple");

        //  EXPECT
        assertThat(tree.isEmpty(), equalTo(false));
        assertThat(tree.size(), equalTo(1));
        assertThat(tree.depth(), equalTo(1));
        assertThat(tree.breadth(), equalTo(1));
        assertThat(tree.contains("simple"), equalTo(true));
    }

    @Test
    @DisplayName("Added one complex string. Size 2, empty false, depth 2, breadth 1. Should find two elements in the tree.")
    public void complexElementTest() {
        //  GIVEN
        tree.add("parent/child");

        //  EXPECT
        assertThat(tree.isEmpty(), equalTo(false));
        assertThat(tree.size(), equalTo(2));
        assertThat(tree.depth(), equalTo(2));
        assertThat(tree.breadth(), equalTo(1));
        assertThat(tree.contains("parent"), equalTo(true));
        assertThat(tree.contains("child"), equalTo(true));
    }

    @Test
    @DisplayName("Added two complex strings. Size 3, empty false, depth 2, breadth 2. Should find three elements in the tree.")
    public void twoComplexElementsTest() {
        //  GIVEN
        tree.add("parent/child");
        tree.add("parent/anotherChild");

        //  EXPECT
        assertThat(tree.isEmpty(), equalTo(false));
        assertThat(tree.size(), equalTo(3));
        assertThat(tree.depth(), equalTo(2));
        assertThat(tree.breadth(), equalTo(2));
        assertThat(tree.contains("parent"), equalTo(true));
        assertThat(tree.contains("child"), equalTo(true));
        assertThat(tree.contains("anotherChild"), equalTo(true));
    }
}
