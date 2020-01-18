package animal_06;

public class Tomcat extends Cat {
    private final static String SOUND = "MEOW";
    private final static String GENDER = "Male";

    public Tomcat(String name, int age) {
        super(name, age, GENDER);
    }

    public static String getSOUND() {
        return SOUND;
    }

    @Override
    public String produceSound() {
        return getSOUND();
    }
}
