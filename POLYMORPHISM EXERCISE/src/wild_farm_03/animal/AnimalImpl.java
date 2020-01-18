package wild_farm_03.animal;

import wild_farm_03.food.Food;

public abstract class AnimalImpl implements Animal {
    String animalType;
    String animalName;
    Double animalWeight;
    Integer foodEaten = 0;

    public AnimalImpl(String animalType, String animalName, Double animalWeight) {
        this.animalType = animalType;
        this.animalName = animalName;
        this.animalWeight = animalWeight;
    }

    public String getAnimalType() {
        return animalType;
    }

    public String getAnimalName() {
        return animalName;
    }

    public Double getAnimalWeight() {
        return animalWeight;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }
    public void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten + this.getFoodEaten();
    }


}
