package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
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
    public void displaySquare() {
        for (int i = 0; i < square.length; i++) {
            System.out.print(i + 1);
            System.out.print("|");
            for (int j = 0; j < square.length; j++) {
                switch (square[i][j]) {
                    case -1:
                        System.out.print("   |");
                        break;
                    case 0:
                        System.out.print(" 0 |");
                        break;
                    case 1:
                        System.out.print(" X |");
                        break;
                }
            }
            System.out.print("\n");
        }
        System.out.print(" ");
        for (int i = 0; i < square.length; i++) {
            System.out.print("  " + (i + 1) + " ");

        }
        System.out.println();
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

    public boolean checkCol(int i, int j, int value, int[][] square) {
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

    public boolean checkRow(int i, int j, int value, int[][] square) {
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

    public boolean checkFirstDiag(int i, int j, int value, int[][] square) {

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

    public boolean checkSecDiag(int i, int j, int value, int[][] square) {

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

    public boolean checkAvailSquare(int i, int j) {
        if (i < len && j < len && i >= 0 && j >= 0 && square[i][j] == -1)
            return true;
        return false;
    }

    public boolean checkWin(int i, int j, int value) {
        if (checkCol(i, j, value) || checkRow(i, j, value) ||
                checkFirstDiag(i, j, value) || checkSecDiag(i, j, value))
            return true;
        return false;
    }

    public boolean checkWin(int i, int j, int value, int[][] square) {
        if (checkCol(i, j, value, square) || checkRow(i, j, value, square) ||
                checkFirstDiag(i, j, value, square) || checkSecDiag(i, j, value, square))
            return true;
        return false;
    }

    public boolean checkDraw() {
        if (movesCount == len * len)
            return true;
        return false;
    }

    public boolean checkDraw(int[][] square) {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                // if not empty
                if (square[i][j] == -1)
                    return false;
            }
        }
        return true;
    }

    public ArrayList<Child> getChildren(int value) {
        ArrayList<Child> children = new ArrayList<Child>(len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                Child child = new Child(len);
                child.setSquare(Arrays.stream(square).map(int[]::clone).toArray(int[][]::new));
                // Si vide
                if (square[i][j] == -1) {
                    child.setSquare(i, j, value);
                    child.setMovePos(i, j);
                    children.add(child);
                    // System.out.println(evaluate(child.getSquare(), i, j, 1));
                }
            }
        }
        return children;
    }

    public ArrayList<Child> getChildren(int[][] square, int value) {
        ArrayList<Child> children = new ArrayList<Child>(len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                Child child = new Child(len);
                child.setSquare(Arrays.stream(square).map(int[]::clone).toArray(int[][]::new));
                // Si vide
                if (square[i][j] == -1) {
                    child.setSquare(i, j, value);
                    child.setMovePos(i, j);
                    children.add(child);
                    // System.out.println(evaluate(child.getSquare(), i, j, 1));
                }
            }
        }
        return children;
    }

    public void display(int[][] square) {
        for (int i = 0; i < len; i++) {
            System.out.print(i + 1);
            System.out.print("|");
            for (int j = 0; j < len; j++) {
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
        System.out.print(" ");
        for (int i = 0; i < len; i++) {
            System.out.print("  " + (i + 1) + " ");

        }
        System.out.println();
    }

    public void displayChildren(ArrayList<Child> children) {
        for (int k = 0; k < children.size(); k++) {
            Child child = children.get(k);
            for (int i = 0; i < len; i++) {
                System.out.print(i + 1);
                System.out.print("|");
                for (int j = 0; j < len; j++) {
                    switch (child.getSquare()[i][j]) {
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
            System.out.print(" ");
            for (int i = 0; i < len; i++) {
                System.out.print("  " + (i + 1) + " ");

            }
            System.out.println();
        }
        System.out.println();

    }

    public int evaluate(int[][] square, int row, int col, int turnValue) {
        if (checkWin(row, col, turnValue, square))
            // win
            return 1;
        else if (checkWin(row, col, 1 - turnValue, square))
            // defeat
            return -1;
        else if (checkDraw(square))
            // draw
            return 0;
        return -2; // nothing to do
    }

    public int[] bestMove(int[][] square, int initTurn, int initColor, int color, int turn, int depth) {
        int[] result = { -1, -1, -2 };
        int score = -2;
        // based on the minmax algorithm
        ArrayList<Child> children = getChildren(square, color);
        int[] values = new int[children.size()];
        int[][] poses = new int[children.size()][2];
        int index = 0;
        for (int k = 0; k < children.size(); k++) {
            Child child = children.get(k);
            if (depth >= (2 * winCount) - 1) { // 2*winCount - 1 is the minimum value to get a leaf
                int eval = evaluate(child.getSquare(), child.getMovePos()[0], child.getMovePos()[1], initColor);
                if (eval != -2) { // if leaf
                    values[k] = eval;
                } else { // if node
                    int[] resultTemp = bestMove(child.getSquare(), initTurn, initColor, 1 - color, 1 - turn, depth + 1);
                    values[k] = resultTemp[2];
                }

            } else { // node for sure
                int[] resultTemp = bestMove(child.getSquare(), initTurn, initColor, 1 - color, 1 - turn, depth + 1);
                values[k] = resultTemp[2];
            }
            poses[k] = children.get(k).getMovePos();
        }
        if (initTurn != turn) {
            // get the min value with its index from the values
            int min = values[0];
            for (int i = 1; i < values.length; i++) {
                if (min > values[i]) {
                    min = values[i];
                    index = i;
                } 
            }
            score = min;
        } else {
            // get the max value with its index from the values
            int max = values[0];
            for (int i = 1; i < values.length; i++) {
                if (max < values[i]) {
                    max = values[i];
                    index = i;
                }
            }
            score = max;
        }
        result[0] = poses[index][0];
        result[1] = poses[index][1];
        result[2] = score;
        return result;
    }

}
