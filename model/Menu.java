package model;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {

    /**
     * constructors
     */

    public Menu() {
        this.description = "";
        this.option = new ArrayList<String>();
    }

    public Menu(String description) {
        this.description = description;
        this.option = new ArrayList<String>();
    }

    public Menu(ArrayList<String> option) {
        this.description = null;
        this.option = option;
    }

    public Menu(String description, ArrayList<String> option) {
        this.description = description;
        this.option = option;
    }

    /**
     * properties
     */

    private String description;
    private ArrayList<String> option;

    // setters
    public void setDescription(String description) {
        this.description = description;
    }

    public void setOption(ArrayList<String> option) {
        this.option = option;
    }

    // getters
    public String getDescription() {
        return description;
    }

    public ArrayList<String> getOption() {
        return option;
    }

    // methods
    public void display() {
        if (description != null) {
            System.out.println(description);
            System.out.println("0. Quit");
            for (int i = 0; i < option.size(); i++) {
                System.out.println((i + 1) + ". " + option.get(i));
            }
        }
        else {
            for (int i = 0; i < option.size(); i++) {
                System.out.println(option.get(i));
            }
        }
    }

    public int getSelection(Scanner s) {
        String choiceStr = s.next();
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(choiceStr);
        while(matcher.find()==false){
            System.out.println("Please enter a valid number");
            choiceStr = s.next();
            matcher = pattern.matcher(choiceStr);
        }
        int choice = Integer.parseInt(choiceStr);
        if (description != null) {
            if (choice == 0) {
                System.exit(0);
            }
            while (choice < 0 || choice > option.size()) {
                System.out.println("Selection out of range");
                choice = Integer.parseInt(s.next());
            }
        }
        else{
            while (choice < 0 || choice > option.size()) {
                System.out.println("Selection out of range");
                choice = Integer.parseInt(s.next());
            }
        }
        return choice;
    }
}
