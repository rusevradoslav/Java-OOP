package wild_farm_03.animal;

import wild_farm_03.food.Food;

import java.text.DecimalFormat;

public class Tiger extends Felime {
    public Tiger(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Meat")) {
            setFoodEaten(food.getQuantity());
        } else {
            System.out.println("Tigers are not eating that type of food!");
            setFoodEaten(0);
        }
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]", super.getAnimalType(), super.getAnimalName(), format.format(super.getAnimalWeight()), super.getLivingRegion(), super.getFoodEaten());
    }
}
