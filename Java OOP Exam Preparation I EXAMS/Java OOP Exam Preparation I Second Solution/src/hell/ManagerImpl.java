package hell;

import hell.entities.miscellaneous.heroes.Assassin;
import hell.entities.miscellaneous.heroes.Barbarian;
import hell.entities.miscellaneous.heroes.HeroesComparator;
import hell.entities.miscellaneous.heroes.Wizard;
import hell.entities.miscellaneous.items.CommonItem;
import hell.entities.miscellaneous.items.RecipeItem;
import hell.interfaces.Hero;
import hell.interfaces.Item;
import hell.interfaces.Manager;
import hell.interfaces.Recipe;

import javax.naming.NamingEnumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ManagerImpl implements Manager {
    private HashMap<String, Hero> localHeroes;

    public ManagerImpl() {
        this.localHeroes = new HashMap<>();
    }

    @Override
    public String addHero(List<String> arguments) {
        Hero result = null;
        String name = arguments.get(0);
        String type = arguments.get(1);
        switch (type) {
            case "Barbarian":
                result = new Barbarian(name);
                break;
            case "Assassin":
                result = new Assassin(name);
                break;
            case "Wizard":
                result = new Wizard(name);
                break;
        }
        localHeroes.put(name, result);

        return String.format("Created %s - %s", type, name);


    }

    @Override
    public String addItem(List<String> arguments) {
        Hero currentHero = this.localHeroes.get(arguments.get(2));
        String itemName = arguments.get(1);
        String heroName = arguments.get(2);
        int strengthBonus = Integer.parseInt(arguments.get(3));
        int agilityBonus = Integer.parseInt(arguments.get(4));
        int intelligenceBonus = Integer.parseInt(arguments.get(5));
        int hitPointsBonus = Integer.parseInt(arguments.get(6));
        int damageBonus = Integer.parseInt(arguments.get(7));
        Item item = new CommonItem(itemName, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
        currentHero.addItem(item);

        return String.format("Added item - %s to Hero - %s"
                , arguments.get(1)
                , heroName);
    }

    @Override
    public String addRecipe(List<String> arguments) {
        Hero currentHero = this.localHeroes.get(arguments.get(2));
        String itemName = arguments.get(1);
        String heroName = arguments.get(2);
        int strengthBonus = Integer.parseInt(arguments.get(3));
        int agilityBonus = Integer.parseInt(arguments.get(4));
        int intelligenceBonus = Integer.parseInt(arguments.get(5));
        int hitPointsBonus = Integer.parseInt(arguments.get(6));
        int damageBonus = Integer.parseInt(arguments.get(7));

        List<String> itemList = arguments.stream().skip(8).collect(Collectors.toList());
        Recipe item = new RecipeItem(itemName, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus, itemList);
        currentHero.addRecipe(item);

        return String.format("Added recipe - %s to Hero - %s"
                , arguments.get(1)
                , heroName);
    }


    @Override
    public String inspect(List<String> arguments) {
        Hero currentHero = localHeroes.get(arguments.get(1));

        return currentHero.toString();
    }

    @Override
    public String quit() {
        HeroesComparator comparator = new HeroesComparator();
        List<Hero> ordered = this.localHeroes
                .values()
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());

        StringBuilder builder = new StringBuilder();

        int index  = 1;
        for (Hero hero : ordered) {
            builder.append(index);
            builder.append(" ");
            builder.append(hero.toString());
            builder.append("\n");
            index++;
        }

        return builder.toString();
    }
}
