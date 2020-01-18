package someValidations;

public class Validator {
    public static void validateSide(String name, double value) {
        if (value <= 0) {
            throw new IllegalArgumentException(String.format("%s cannot be zero or negative.", name));

        }
    }

    public static void validateName(String name) throws IllegalArgumentException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
    }

    public static void validateAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
    }

    public static void validateCost(double cost) throws IllegalArgumentException {
        if (cost < 0) {
            throw new IllegalArgumentException("Money cannot be negative");

        }
    }


}
