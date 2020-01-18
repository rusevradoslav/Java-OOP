package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroRepositoryTest {
    Item item;
    Item item2;
    Hero hero;
    Hero hero2;
    HeroRepository repository;
    private static final int DEFAULT_STRENGTH = 10;
    private static final int DEFAULT_ABILITY = 10;
    private static final int DEFAULT_INTELLIGENCE = 10;
    private static final String NAME = "Pesho";
    private static final int DEFAULT_LEVEL = 1;

    @Before
    public void creatingConstructor() {
        item = new Item(DEFAULT_STRENGTH, DEFAULT_ABILITY, DEFAULT_INTELLIGENCE);
        item2 = new Item(DEFAULT_STRENGTH + 10, DEFAULT_ABILITY + 10, DEFAULT_INTELLIGENCE + 10);
        hero = new Hero(NAME, DEFAULT_LEVEL, item);
        hero2 = new Hero("Kiril", DEFAULT_LEVEL + 1, item2);
        repository = new HeroRepository();
    }

    @Test
    public void creatingConstructorWorkCorrectly() {
        Assert.assertEquals(0, repository.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addHeroTwoTimesShouldThrowException() {
        repository.add(hero);
        repository.add(hero);
    }

    @Test
    public void addHeroWorkCorrectly() {
        repository.add(hero);
        Hero hero2 = new Hero("Kiril", DEFAULT_LEVEL + 1, item);
        repository.add(hero2);
        Assert.assertEquals(2, repository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void removeHeroShouldThrowExceptionIfHeroDoesntExist() {
        repository.add(hero);
        repository.remove("Kiril");
    }

    @Test
    public void removeMethodShouldWorkCorrectly() {
        repository.add(hero);
        repository.add(hero2);
        repository.remove("Kiril");
        Assert.assertEquals(1, repository.getCount());
    }

    @Test
    public void
    getHeroWithHighestStrengthShouldWorkCorrectly() {
        repository.add(hero);
        repository.add(hero2);
        Hero heroWithHighestStrength = repository.getHeroWithHighestStrength();
        Assert.assertEquals(hero2, heroWithHighestStrength);
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestStrengthShouldThrowException() {
         item = new Item(0, DEFAULT_ABILITY, DEFAULT_INTELLIGENCE);
         item2 = new Item(0, DEFAULT_ABILITY + 10, DEFAULT_INTELLIGENCE + 10);
         Hero hero = new Hero(NAME, DEFAULT_LEVEL, item);
         Hero hero2 = new Hero("Kiril", DEFAULT_LEVEL + 1, item2);
         repository.add(hero);
         repository.add(hero2);
         Hero heroWithHighestStrength = repository.getHeroWithHighestStrength();
         Assert.assertEquals(null, heroWithHighestStrength);


    }

    @Test
    public void
    getHeroWithHighestAbilityShouldWorkCorrectly() {
        repository.add(hero);
        repository.add(hero2);
        Hero heroWithHighestAgility = repository.getHeroWithHighestAgility();
        Assert.assertEquals(hero2, heroWithHighestAgility);
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestAbilityShouldThrowException() {
       item = new Item(DEFAULT_STRENGTH, 0, DEFAULT_INTELLIGENCE);
       item2 = new Item(DEFAULT_STRENGTH + 10, 0, DEFAULT_INTELLIGENCE + 10);
       Hero hero = new Hero(NAME, DEFAULT_LEVEL, item);
       Hero hero2 = new Hero("Kiril", DEFAULT_LEVEL + 1, item2);
       repository.add(hero);
       repository.add(hero2);
       Hero heroWithHighestAgility = repository.getHeroWithHighestAgility();
       Assert.assertEquals(null, heroWithHighestAgility);

    }

    @Test
    public void
    getHeroWithHighestIntelligenceShouldWorkCorrectly() {
        repository.add(hero);
        repository.add(hero2);
        Hero heroWithHighestIntelligence = repository.getHeroWithHighestIntelligence();
        Assert.assertEquals(hero2, heroWithHighestIntelligence);
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestIntelligenceShouldThrowException() {
       item = new Item(DEFAULT_STRENGTH, DEFAULT_ABILITY, 0);
       item2 = new Item(DEFAULT_STRENGTH + 10, DEFAULT_ABILITY + 10, 0);
       Hero hero = new Hero(NAME, DEFAULT_LEVEL, item);
       Hero hero2 = new Hero("Kiril", DEFAULT_LEVEL + 1, item2);
       repository.add(hero);
       repository.add(hero2);
       Hero heroWithHighestIntelligence = repository.getHeroWithHighestIntelligence();
       Assert.assertEquals(null, heroWithHighestIntelligence);

    }

    @Test
    public void testOutputMessage() {
        repository.add(hero);
        String format = repository.toString();
        String heroString = String.format("Hero: %s – %d%n" +
                        "  *  Strength: %d%n" +
                        "  *  Agility: %d%n" +
                        "  *  Intelligence: %d%n", hero.getName(), hero.getLevel(),
                hero.getItem().getStrength(), hero.getItem().getAgility(), hero.getItem().getIntelligence());

        Assert.assertEquals(heroString, format);
    }


}