package animal_farm_02;


import static someValidations.Validator.validateAge;
import static someValidations.Validator.validateName;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private void setName(String name) {
        validateName(name);
        this.name = name;
    }

    private void setAge(int age) {
        validateAge(age);
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        double param = 0;
        if (this.age < 6) {
            param = 2;
        } else if (this.age >= 6 && this.age < 12) {
            param = 1;
        } else if (this.age >= 12) {
            param = 0.75;
        }
        return param;
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", getName(), getAge(), calculateProductPerDay());
    }
}
