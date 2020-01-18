package animals_03;

public class Cat extends Animal {

    protected Cat(String name, String favoriteFood) {
        super(name, favoriteFood);
    }

    @Override
    public String explainSelf() {
        return super.explainSelf()+"MEEOW";
    }
}
