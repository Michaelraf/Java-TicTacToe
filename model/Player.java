package model;

public class Player {
    /**
     * constructors
     */
    public Player() {
        this.name = "";
        this.color = 0;
    }

    public Player(String name, int color) {
        this.name = name;
        this.color = color;
    }

    private String name;
    private int color;

    /**
     * methods
     */

    // setters

    public void setName(String name){
        this.name = name;
    }
    public void setColor(int color){
        this.color = color;
    }
    
    // getters
    
    public String getName(){
        return this.name;
    }
    public int getColor(){
        return this.color;
    }

    // display

    public void display(){
        char playerColor;
        if (color == 0)
            playerColor = 'O';
        else
            playerColor = 'X';
        System.out.println("Name : "+ name +", Color: " + playerColor);
    }
}