package p03_ListIteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p03_ListIterator.ListIterator;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTests {
    private ListIterator listIterator;

    @Before
    public void cratingListIterator() throws OperationNotSupportedException {
        this.listIterator = new ListIterator("First", "Second");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowExceptionIfIsEmpty() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test(expected = IllegalStateException.class)
    public void printShouldThrowExceptionWhenListIteratorSizeIsNull() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void printShouldReturnStringOfTheCurrentIndex() {
        String currentElement = listIterator.print();
        Assert.assertEquals("First", currentElement);
    }

    @Test
    public void moveShouldReturnTrue() {
        Assert.assertTrue(this.listIterator.move());
    }

    @Test
    public void moveShouldReturnFalseWhenListIteratorHasNoMoreElements() {
        this.listIterator.move();
        Assert.assertFalse(this.listIterator.move());
    }

    @Test
    public void hasNextShouldReturnTrue() {
        Assert.assertTrue(this.listIterator.hasNext());
    }

    @Test
    public void hasNextShouldReturnFalseWhenListIteratorHasNoMoreElements() {
        this.listIterator.move();
        Assert.assertFalse(listIterator.hasNext());
    }

    @Test
    public void shouldPrintTheNextElement() {
        this.listIterator.move();
        Assert.assertEquals("Second", listIterator.print());
    }
}

