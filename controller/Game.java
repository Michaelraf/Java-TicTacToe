package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.Grid;
import model.Menu;
import model.Player;

public class Game {
    /**
     * properties
     */
    private Grid grid;
    private Player[] players;
    private Menu mainMenu;
    private Menu colorMenu;

    public Game() {
        ArrayList<String> mainOptions = new ArrayList<String>();
        ArrayList<String> colorOptions = new ArrayList<String>();
        mainOptions.add("Play against friend");
        mainOptions.add("Play against computer");
        colorOptions.add("0: O");
        colorOptions.add("1: X");

        grid = new Grid();
        players = new Player[2];
        for (int i = 0; i < 2; i++) {
            this.players[i] = new Player();
        }
        mainMenu = new Menu("Main Menu", mainOptions);
        colorMenu = new Menu(colorOptions);
    }

    /*
     * methods
     */

    public String getInput(Scanner s) {
        String choice = s.next();
        return choice;
    }

    public void intro(Scanner s) {
        int choice = 0;
        int color = 0;
        String name = "";
        mainMenu.display();
        choice = mainMenu.getSelection(s);
        if (choice == 1) {
            System.out.print("Player 1 name: ");
            name = getInput(s);
            players[0].setName(name);
            System.out.print("Player 2 name: ");
            name = getInput(s);
            players[1].setName(name);
            System.out.println(players[0].getName()+", choose color: ");
            colorMenu.display();
            color = colorMenu.getSelection(s);
            players[0].setColor(color);
            players[1].setColor(1 - color);
        } else {
            System.out.print("Player's name: ");
            name = getInput(s);
            players[0].setName(name);
            players[1].setName("BOT");
            System.out.println(players[0].getName()+", choose color: ");
            colorMenu.display();
            color = colorMenu.getSelection(s);
            players[0].setColor(color);
            players[1].setColor(1 - color);
        }
        players[0].display();
        players[1].display();
    }

    public void play(Scanner s) {
        int turn = 0; // 0 for player1 and 1 for player2
        int row = -1;
        int col = -1;
        grid.init();
        while (true) {
            System.out.println(players[turn].getName() + "'s turn");
            System.out.println("row: ");
            row = Integer.parseInt(getInput(s))-1;
            System.out.println("col: ");
            col = Integer.parseInt(getInput(s))-1;
            while (!grid.checkAvailSquare(row, col)) {
                System.out.println("Square not available");
                System.out.println(players[turn].getName() + "'s turn");
                System.out.println("row: ");
                row = Integer.parseInt(getInput(s))-1;
                System.out.println("col: ");
                col = Integer.parseInt(getInput(s))-1;
            }
            grid.updateSquare(row, col, players[turn].getColor());
            grid.display();
            if (grid.checkDraw()) {
                System.out.println("Draw !");
                break;
            }
            if (grid.checkWin(row, col, players[turn].getColor())) {
                System.out.println(players[turn].getName() + " wins");
                break;
            }
            turn = 1 - turn;
        }
    }

}