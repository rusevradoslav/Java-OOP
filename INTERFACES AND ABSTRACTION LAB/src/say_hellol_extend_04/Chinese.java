package say_hellol_extend_04;

public class Chinese extends BasePerson {
    protected Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
