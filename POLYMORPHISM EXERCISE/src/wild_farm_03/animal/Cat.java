package wild_farm_03.animal;

import wild_farm_03.food.Food;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalType, String animalName,Double animalWight, String livingRegion,String breed) {
        super(animalName, animalType, animalWight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        setFoodEaten(food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %d]", super.getAnimalType(), super.getAnimalName(), this.breed,format.format(super.getAnimalWeight()), super.getLivingRegion(), super.getFoodEaten());
    }
}

