package hell.entities.miscellaneous.items;

import hell.interfaces.Recipe;

import java.util.List;

public class RecipeItem extends Items implements Recipe {
    private List<String> requiredItems;

    public RecipeItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus,List<String> required) {
        super(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
        this.requiredItems = required;
    }


    public List<String> getRequiredItems() {
        return this.requiredItems;
    }
}
