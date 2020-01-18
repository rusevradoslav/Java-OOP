package p05_CustomLinkedListTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p05_CustomLinkedList.CustomLinkedList;

import java.util.LinkedList;

public class CustomListTest {
    private CustomLinkedList<Integer> customLinkedList;

    @Before
    public void init() {
        customLinkedList = new CustomLinkedList<>();
    }

    @Test(expected = IllegalArgumentException.class)
    public void getShouldThrowExceptionIfIndexIsNotValid() {
        customLinkedList.get(-1);
    }

    @Test
    public void getShouldReturnElementAtTheGivenIndex() {
        customLinkedList.add(33);
        int value = customLinkedList.get(0);
        Assert.assertEquals(33, value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getShouldThrowExceptionIfGivenIndexIsGreater() {
        customLinkedList.add(33);
        customLinkedList.get(1);
    }


    @Test(expected = IllegalArgumentException.class)
    public void setShouldThrowExceptionIfIndexIsNotValid() {
        customLinkedList.set(-1, 33);
    }

    @Test
    public void setShouldAddElementInTheCorrectIndex() {
        customLinkedList.add(33);
        customLinkedList.set(0, 34);
        Assert.assertEquals(customLinkedList.get(0).intValue(), 34);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setShouldThrowExceptionIfIndexIsGreater() {
        customLinkedList.add(33);
        customLinkedList.add(34);
        customLinkedList.set(3, 33);
    }

    @Test
    public void addShouldAddInLastIndex() {
        customLinkedList.add(33);
        customLinkedList.add(34);
        Assert.assertEquals(customLinkedList.get(1).intValue(), 34);
    }

    @Test
    public void shouldReturnAndRemoveElementAtGivenPosition() {
        customLinkedList.add(33);
        int value = customLinkedList.removeAt(0);
        Assert.assertEquals(33, value);
    }

    @Test
    public void shouldRemoveAndReturnTheIndexToTheGivenElement() {
        customLinkedList.add(33);
        int index = customLinkedList.remove(33);
        Assert.assertEquals(0, index);
    }

    @Test
    public void shouldReturnNegativeResultIfTheElementIsNotFound() {
        customLinkedList.add(33);
        int index = customLinkedList.remove(34);
        Assert.assertEquals(-1, index);
    }

    @Test
    public void shouldReturnIndexOfFirstIndexInCollection() {
        customLinkedList.add(33);
        customLinkedList.add(34);
        customLinkedList.add(35);
        int index = customLinkedList.indexOf(33);
        Assert.assertEquals(0, index);
    }

    @Test
    public void shouldReturnNegativeResultIfIndexOfGivenElementDoesntExists() {
        customLinkedList.add(33);
        int index = customLinkedList.indexOf(100);
        Assert.assertEquals(-1, index);
    }

    @Test
    public void shouldReturnTrueIfCollectionContainsElement() {
        customLinkedList.add(33);
        Assert.assertTrue(customLinkedList.contains(33));
    }
    @Test
    public void shouldReturnFalseIfCollectionContainsElement() {
        customLinkedList.add(33);
        Assert.assertFalse(customLinkedList.contains(100));
    }

}
