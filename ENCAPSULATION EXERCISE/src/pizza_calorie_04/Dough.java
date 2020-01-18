package pizza_calorie_04;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    public String getFlourType() {
        return flourType;
    }

    private void setFlourType(String flourType) {
        try {
            FlourType.valueOf(flourType);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    public String getBakingTechnique() {
        return bakingTechnique;
    }

    private void setBakingTechnique(String bakingTechnique)  {
        try {
            DoughType.valueOf(bakingTechnique);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    public double getWeight() {
        return weight;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double calories = 2 * this.getWeight();
        switch (getFlourType()) {
            case "White":
                calories *= 1.5;
                break;
            case "Wholegrain":
                calories *= 1.0;
                break;
        }
        switch (getBakingTechnique()) {
            case "Crispy":
                calories *= 0.9;
                break;
            case "Chewy":
                calories *= 1.1;
                break;
            case "Homemade":
                calories *= 1.0;
                break;
        }


        return calories;
    }
}
