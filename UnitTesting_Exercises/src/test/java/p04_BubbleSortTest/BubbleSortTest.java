package p04_BubbleSortTest;

import com.sun.source.tree.AssertTree;
import org.junit.Assert;
import org.junit.Test;
import p04_BubbleSort.Bubble;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class BubbleSortTest {

    private int[] elements = {13, 42, 69, -1, 0, 0, -2, -34};
    private int[] sorted = Arrays.stream(elements).sorted().toArray();

    @Test
    public void sortShouldSortTheCollections() {
        Bubble.sort(elements);
        Assert.assertArrayEquals(sorted, elements);
    }
    @Test
    public void sortShouldSortTheCollectionsAndReturnTheSameCollection() {
        Bubble.sort(sorted);
        Assert.assertArrayEquals(sorted, sorted);
    }
}
