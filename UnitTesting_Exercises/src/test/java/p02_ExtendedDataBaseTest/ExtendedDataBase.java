package p02_ExtendedDataBaseTest;

import org.junit.Assert;
import org.junit.Test;
import p02_ExtendedDatabase.Database;
import p02_ExtendedDatabase.Person;

import javax.naming.OperationNotSupportedException;

public class ExtendedDataBase {
    private static final Person[] people = new Person[2];
    private Person person1 = new Person(100, "Pesho");



    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowExceptionIfPersonListIsEmpty() throws OperationNotSupportedException {
        Database db = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldHaveMaximumSixteenPersons() throws OperationNotSupportedException {
        Database db = new Database(new Person[17]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addingEmptyPersonShouldThrowException() throws OperationNotSupportedException {
        Database db = new Database(people);
        db.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addingShouldThrowExceptionIfPersonIsWithInvalidId() throws OperationNotSupportedException {
        Person person = new Person(-3, "Pesho");
        Database database = new Database(people);
        database.add(person);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addingShouldThrowExceptionIfPersonIsWithInvalidName() throws OperationNotSupportedException {
        Person person = new Person(323, "");
        Database database = new Database(people);
        database.add(person);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addingShouldThrowExceptionIfTheIdIsNotUnique() throws OperationNotSupportedException {
        Person person1 = new Person(27, "Pesho");
        Person person2 = new Person(27, "Gosho");
        Database db = new Database(person1);

        db.add(person2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addingShouldThrowExceptionIfTheNameIsNotUnique() throws OperationNotSupportedException {
        Person person2 = new Person(101, "Pesho");
        Database db = new Database(person1);

        db.add(person2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeShouldThrowExceptionIfIndexIsNotValid() throws OperationNotSupportedException {
        Database db = new Database(person1);
        db.remove();
        db.remove();
    }

    @Test
    public void removeShouldDecreaseElements() throws OperationNotSupportedException {
        Database db = new Database(person1);
        db.remove();
        Assert.assertEquals(db.getElements().length, 0);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByIdShouldThrowExceptionIfThereIsNotAPersonWithThisId() throws OperationNotSupportedException {
        Database db = new Database(person1);
        //id of Person1 is 100
        db.findById(101);
    }

    @Test
    public void findByIdShouldReturnThePersonWithTheGivenId() throws OperationNotSupportedException {
        Database db = new Database(person1);
        Person person = db.findById(100);
        Assert.assertEquals(person1, person);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameShouldThrowExceptionIfThereIsNotAPersonWithThisName() throws OperationNotSupportedException {
        Database db = new Database(person1);
        //name of Person1 is Pesho
        db.findByUsername("Gosho");
    }

    @Test
    public void findByUsernameShouldReturnThePersonWithTheGivenName() throws OperationNotSupportedException {
        Database db = new Database(person1);
        Person person = db.findByUsername("Pesho");
        Assert.assertEquals(person1, person);
    }
}
