package animal_06;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.name = setName(name);
        this.age = setAge(age);
        this.gender = setGender(gender);
    }

    public String getName() {
        return name;
    }

    public String setName(String name) throws IllegalArgumentException {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
        return this.name = name;

    }

    public int getAge() {
        return age;
    }

    public int setAge(int age) throws IllegalArgumentException {
        if (age <= 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        return this.age = age;

    }

    public String getGender() {
        return gender;
    }

    public String setGender(String gender) throws IllegalArgumentException {
        if (gender.isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
        return this.gender = gender;

    }

    public String produceSound() {
        return "Not implemented";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s%n%s %d %s%n%s%n", this.getClass().getSimpleName(), this.name, this.age, this.gender, this.produceSound()).trim());
        return sb.toString().trim();
    }
}
