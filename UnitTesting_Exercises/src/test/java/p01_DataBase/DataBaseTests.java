package p01_DataBase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;

public class DataBaseTests {

    private static final Integer[] ELEMENTS = new Integer[]{13, 49, 69, 72};
    private static final int MAX_ELEMENTS_COUNT = 17;
    private Database database;

    @Before
    public void creatDataBase() throws OperationNotSupportedException {
        this.database = new Database(ELEMENTS);
    }

    @Test
    public void creatingDateBaseShouldSetElementsCorrectly() throws OperationNotSupportedException {
        Assert.assertArrayEquals(database.getElements(), ELEMENTS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void creatingDatabaseWithZeroElementsShouldThrowException() throws OperationNotSupportedException {
        Database database = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void creatingDatabaseWithMoreThanSixteenElementsShouldThrowException() throws OperationNotSupportedException {
        Database database = new Database(new Integer[MAX_ELEMENTS_COUNT]);
    }

    @Test
    public void shouldAddElementsCorrectly() throws OperationNotSupportedException {
        this.database.add(17);
        Assert.assertEquals(this.database.getElements().length, ELEMENTS.length + 1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addingNullShouldThrowUnException() throws OperationNotSupportedException {
        this.database.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removingElementOnEmptyDatabaseShouldThrowException() throws OperationNotSupportedException {
        for (int i = 0; i < ELEMENTS.length; i++) {
            this.database.remove();
        }
        this.database.remove();
    }

    @Test
    public void removeShouldDecreaseElementsCount() throws OperationNotSupportedException {
        this.database.remove();
        Assert.assertEquals(this.database.getElements().length, ELEMENTS.length - 1);
    }

}
