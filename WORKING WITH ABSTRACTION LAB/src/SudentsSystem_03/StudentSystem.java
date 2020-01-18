package SudentsSystem_03;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }

    public Map<String, Student> getRepo() {
        return this.repo;
    }

    public void executeCommand(String[] tokens) {
        String command = tokens[0];


        if (command.equals("Create")) {
            executeCommandCreate(tokens);
        } else if (command.equals("Show")) {
            String name = tokens[1];
            if (!repo.containsKey(name)) {return;}
            executeCommandShow(name,tokens);
        }
    }

    private void executeCommandShow(String name, String[] tokens) {
        Student student = repo.get(name);
        System.out.println(student.toString());
    }

    private void executeCommandCreate(String[] tokens) {
        String name = tokens[1];
        int age = Integer.parseInt(tokens[2]);
        double grade = Double.parseDouble(tokens[3]);
        Student student = new Student(name, age, grade);
        repo.putIfAbsent(name, student);

    }
}
