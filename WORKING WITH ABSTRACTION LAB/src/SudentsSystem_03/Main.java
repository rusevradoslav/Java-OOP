package SudentsSystem_03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        String line = scanner.nextLine();
        while (!line.equals("Exit")) {
            String[] tokens = line.split("\\s+");

            studentSystem.executeCommand(tokens);
            line = scanner.nextLine();
        }



    }
}
