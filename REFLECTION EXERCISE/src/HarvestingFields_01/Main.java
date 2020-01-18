package HarvestingFields_01;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Class clazz = RichSoilLand.class;


        Field[] declaredFields = clazz.getDeclaredFields();

        int count = 0;
        String format = "%s %s %s";
        String line = scanner.nextLine();

        while (!line.equals("HARVEST") && count < 100) {
            if (line.equals("all")) {
                Arrays.stream(declaredFields).forEach(field ->
                        System.out.println(String.format(format,
                                Modifier.toString(field.getModifiers()),
                                field.getType().getSimpleName(),
                                field.getName())));
            } else {
                String finalLine = line;
                Arrays.stream(declaredFields).filter(field -> Modifier.toString(field.getModifiers()).equals(finalLine))
                        .forEach(field -> System.out.println(String.format(format,
                                Modifier.toString(field.getModifiers()),
                                field.getType().getSimpleName(),
                                field.getName()
                        )));
            }

            line = scanner.nextLine();
            count++;
        }
    }
}
//    Scanner scanner = new Scanner(System.in);
//    String input = scanner.nextLine();
//    int inputCount = 0;
//
//    Field[] fields = RichSoilLand.class.getDeclaredFields();
//
//    String format = "%s %s %s";
//    while ((!input.equals("HARVEST")) && inputCount < 100) {
//        if (input.equals("all")) {
//            Arrays.stream(fields)
//                    .forEach(field -> {
//                        System.out.println
//                                (String.format(format,
//                                        Modifier.toString(field.getModifiers()),
//                                        field.getType().getSimpleName(),
//                                        field.getName()));
//                    });
//        } else {
//            String finalInput = input;
//            Arrays.stream(fields)
//                    .filter(field -> Modifier.toString(field.getModifiers()).equals(finalInput))
//                    .forEach(field ->
//                            System.out.println
//                                    (String.format(format,
//                                            Modifier.toString(field.getModifiers()),
//                                            field.getType().getSimpleName(),
//                                            field.getName())));
//        }
//        input = scanner.nextLine();
//        inputCount++;
//    }

