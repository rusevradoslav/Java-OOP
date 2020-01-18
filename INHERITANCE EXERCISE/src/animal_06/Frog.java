package animal_06;

public class Frog extends Animal {
    private final static String SOUND = "Ribbit";
    public Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    public static String getSOUND() {
        return SOUND;
    }

    @Override
    public String produceSound() {
        return getSOUND();
    }
}
