import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Class reflection = Reflection.class;

        Method[] declaredFields = reflection.getDeclaredMethods();

        Arrays.stream(declaredFields).filter(e -> e.getName().startsWith("get")
                && e.getParameterCount() == 0).sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.println(String.format("%s will return class %s", method.getName(), method.getReturnType())));

        Arrays.stream(declaredFields).filter(e -> e.getName().startsWith("set")
                && e.getReturnType().equals(void.class)).sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.println(String.format("%s and will set field of class %s", method.getName(), method.getParameters()[0].getType().getName())));


        Field field = reflection.getClass().getDeclaredField("Java");
        field.setAccessible(true);
       field.set(reflection,"C++");

    }
}
