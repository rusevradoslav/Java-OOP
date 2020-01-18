package animals_03;

public class Dog extends Animal {
    protected Dog(String name, String favoriteFood) {
        super(name, favoriteFood);
    }

    @Override
    public String explainSelf() {
        return super.explainSelf()+"DJAAF";
    }
}
