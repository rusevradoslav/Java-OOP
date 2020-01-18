package shapes_02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Shape rectangle = new Rectangle(3.0, 5.0);
        Shape circle = new Circle(6.0);
        System.out.println(rectangle.calculateArea());
        System.out.println(rectangle.calculatePerimeter());
        System.out.println(circle.calculateArea());
        System.out.println(circle.calculatePerimeter());
    }
}
