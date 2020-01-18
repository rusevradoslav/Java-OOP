package RandomArrayList_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        RandomArrayList list = new RandomArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(list.getRandomElement());


    }
}
