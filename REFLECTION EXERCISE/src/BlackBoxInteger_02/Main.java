package BlackBoxInteger_02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Scanner scanner = new Scanner(System.in);

        Class clazz = BlackBoxInt.class;

        Field innerValue = clazz.getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);

        BlackBoxInt blackBoxInt = null;
        blackBoxInt = (BlackBoxInt) constructor.newInstance();

        Method[] methods = clazz.getDeclaredMethods();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split("_");
            String command = tokens[0];
            int value = Integer.parseInt(tokens[1]);
            Method method = Arrays.stream(methods)
                    .filter(method1 -> method1.getName().equals(command))
                    .findFirst().orElse(null);


            method.setAccessible(true);
            method.invoke(blackBoxInt, value);

            int outputValue = innerValue.getInt(blackBoxInt);
            System.out.println(outputValue);


            input = scanner.nextLine();
        }


    }
}
