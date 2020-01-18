package say_hellol_extend_04;

public class European extends BasePerson {
    protected European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
