package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Grid {
    public Grid() {
        File file = new File("./model/data.txt");
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            this.len = Integer.parseInt(scanner.next());
            this.winCount = Integer.parseInt(scanner.next());
            this.square = new int[len][len];

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
            e.printStackTrace();
        }
    }

    private int[][] square;
    private int winCount;
    private int len;
    private int movesCount;

    // setter
    public void setSquare(int[][] square) {
        if (square.length != len) {
            System.out.println("Length doesn't correspond to the initial length");
            System.exit(-1);
        }
        this.square = square;
    }

    // there is no setter for len for security

    // getter
    public int[][] getSquare() {
        return square;
    }

    // init method
    public void init() {
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                square[i][j] = -1; // empty
            }
        }
    }

    // setter for square element

    public void updateSquare(int i, int j, int value) {
        square[i][j] = value;
        movesCount++;
    }

    // other methods
    public void display() {
        for (int i = 0; i < square.length; i++) {
            System.out.print("|");
            for (int j = 0; j < square.length; j++) {
                switch (square[i][j]) {
                    case -1:
                        System.out.print("   |");
                        break;
                    case 0:
                        System.out.print(" O |");
                        break;
                    case 1:
                        System.out.print(" X |");
                        break;
                }
            }
            System.out.print("\n");
        }
    }

    public boolean checkCol(int i, int j, int value) {
        int count = 0;
        for (int k = 0; k < len; k++) {
            if (square[k][j] == value) {
                count++;
                if (count >= winCount)
                    return true;
            } else {
                count = 0;
            }
        }
        return false;
    }

    public boolean checkRow(int i, int j, int value) {
        int count = 0;
        for (int k = 0; k < len; k++) {
            if (square[i][k] == value) {
                count++;
                if (count >= winCount)
                    return true;
            } else {
                count = 0;
            }
        }
        return false;
    }

    public boolean checkFirstDiag(int i, int j, int value) {

        int count = 0;
        int curRow = i;
        int curCol = j;
        // going up first
        while (curRow >= 0 && curCol >= 0 && square[curRow][curCol] == value) {
            count++;
            curCol--;
            curRow--;
        }
        // then going down if possible
        if (i + 1 < len && j + 1 < len) {
            curRow = i + 1;
            curCol = j + 1;
            while (curRow < len && curCol < len && square[curRow][curCol] == value) {
                count++;
                curCol++;
                curRow++;
            }
        }
        if (count >= winCount)
            return true;
        return false;
    }

    public boolean checkSecDiag(int i, int j, int value) {

        int count = 0;
        int curRow = i;
        int curCol = j;
        // going up first
        while (curRow >= 0 && curCol < len && square[curRow][curCol] == value) {
            count++;
            curCol++;
            curRow--;
        }
        // then going down if possible
        if (i + 1 < len && j - 1 >= 0) {
            curRow = i + 1;
            curCol = j - 1;
            while (curRow < len && curCol >= 0 && square[curRow][curCol] == value) {
                count++;
                curCol--;
                curRow++;
            }
        }
        if (count >= winCount)
            return true;
        return false;
    }

    public boolean checkAvailSquare(int i, int j){
        if (i< len && j<len && i>=0 && j>=0 &&  square[i][j]==-1)
            return true;
        return false;
    }

    public boolean checkWin(int i, int j, int value) {
        if (checkCol(i, j, value) || checkRow(i, j, value) ||
                checkFirstDiag(i, j, value) || checkSecDiag(i, j, value))
            return true;
        return false;
    }

    public boolean checkDraw() {
        if (movesCount == len*len)
            return true;
        return false;
    }
}
