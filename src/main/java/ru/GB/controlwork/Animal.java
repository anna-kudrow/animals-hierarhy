package ru.GB.controlwork;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class Animal {

    private static int counter;
    private static int idCounter = 0;
    protected String type;
    protected String name;
    protected Date birthday;
    protected String commands;
    private int id;

    public static int getCounter(){
        return counter;
    }

    {
        counter ++;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }


    public Animal(String type, String name, Date birthday, String commands) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
        this.commands = commands;
    }
//    public static Scanner in;
    Scanner sc = new Scanner(System.in);


    public void educate(int id, ArrayList<Animal> animals) {
        String newCommand;
        System.out.println("What the command does it know now?: ");
        newCommand = sc.toString();
        for (Animal animal : animals) {
            if (animal.id == id) {
                animal.commands +=  ", " + newCommand;
            }
        }
    }
    public void showSkills(){
        System.out.println("The animal have these skills: " + commands);
    }


    public static void addNewAnimal(ArrayList<Animal> animals) throws ParseException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input type of animal: ");
        String type = "";
        type = sc.nextLine();
        String name = "";
        String commands = "";
        System.out.println("Enter name: ");
        name = sc.nextLine();
        System.out.println("Enter bday: ");
        String input = sc.nextLine();
        DateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        Date bday = formatter.parse(input);
        System.out.println("Enter commands: ");
        commands = sc.nextLine();
        if (type.contains("dog") || type.contains("cat") || type.contains("hamster")) {
            Pet pet = new Pet(type, name, bday, commands);
            animals.add(pet);
        }
        if (type.contains("donkey") || type.contains("camel") || type.contains("horse")) {
            PackAnimal packAnimal = new PackAnimal(type, name, bday, commands);
            animals.add(packAnimal);
        }
        else {
            System.out.println("No this type of anilmal ");
        }
        System.out.println("Animal is added!");
    }

    public static void showAllAnimals(ArrayList<Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal.id + animal.type + animal.name);
        }
    }
}


