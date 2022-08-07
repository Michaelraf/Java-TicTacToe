package test;

import java.util.ArrayList;

import model.Child;
import model.Grid;

public class Test {
    public Test() {

    }

    public void run() {
        /// We will make the test in favor of the "X" color
        Grid grid = new Grid();

        // an empty square
        int[][] squareE = { { -1, -1, -1 }, { -1, -1, -1 }, { -1, -1, -1 } };
        // a row win square
        int[][] squareR = { { 0, -1, 1 }, { -1, 0, 0 }, { 1, 1, 1 } };
        // a col win square
        int[][] squareC = { { 0, 1, 1 }, { 0, 0, 1 }, { 1, 0, 1 } };
        // a first diag win square
        int[][] squareFD = { { 1, -1, -1 }, { 0, 1, -1 }, { -1, 0, 1 } };
        // a sec diag win square
        int[][] squareSD = { { -1, -1, 1 }, { 0, 1, -1 }, { 1, 0, -1 } };
        // a defeat square
        int[][] squareDf = { { 1, 0, 0 }, { 1, 1, 0 }, { 0, 1, 0 } };
        // a draw square
        int[][] squareDr = { { 0, 1, 1 }, { 1, 0, 0 }, { 1, 0, 1 } };


        ///Squares for best move
        // simple test square
        int[][] squareBMs = { { 0, -1, 1 }, { -1, 0, -1 }, { 1, 0, 1 } };
        // 3rd move square
        int[][] squareBM3 = { { 1, -1, -1 }, { -1, 0, -1 }, { -1, -1, -1 } };


        /// Tests
        // Displays
        System.out.println("Display: Empty square");
        grid.display(squareE);
        System.out.println("Display: Row Win square");
        grid.display(squareR);
        System.out.println("Display: Col Win square");
        grid.display(squareC);
        System.out.println("Display: First Diag square");
        grid.display(squareFD);
        System.out.println("Display: Sec Diag square");
        grid.display(squareSD);
        System.out.println("Display: Defeat square");
        grid.display(squareDf);
        System.out.println("Display: Draw square");
        grid.display(squareDr);
        System.out.println("Display: Best move square");
        grid.display(squareBMs);
        System.out.println("Display: 3rd best move square");
        grid.display(squareBM3);

        System.out.println();

        // Checks functions
        System.out.print("Check: Row win: ");
        System.out.println(grid.checkRow(2, 1, 1, squareR));
        System.out.print("Check: Col win: ");
        System.out.println(grid.checkCol(1, 2, 1, squareC));
        System.out.print("Check: First Diag win: ");
        System.out.println(grid.checkFirstDiag(1, 1, 1, squareFD));
        System.out.print("Check: Sec Diag win: ");
        System.out.println(grid.checkSecDiag(1, 1, 1, squareSD));
        System.out.print("Check: Draw: ");
        System.out.println(grid.checkDraw(squareDr));

        System.out.println();

        // Check Win function
        System.out.print("Check Win: Row: ");
        System.out.println(grid.checkWin(2, 1, 1, squareR));
        System.out.print("Check Win: Col:");
        System.out.println(grid.checkWin(1, 2, 1, squareC));
        System.out.print("Check Win: First Diag: ");
        System.out.println(grid.checkWin(1, 1, 1, squareFD));
        System.out.print("Check Win: Sec Diag: ");
        System.out.println(grid.checkWin(1, 1, 1, squareSD));
        
        System.out.println();

        // Evaluate function
        System.out.println( "Evaluate: Empty square: " + (grid.evaluate(squareE, 0, 0, 1)==-2));
        System.out.println( "Evaluate: Win square: " + (grid.evaluate(squareSD, 1, 1, 1)==1));
        System.out.println( "Evaluate: Defeat square: " + (grid.evaluate(squareDf, 1, 2, 1)==-1));
        System.out.println( "Evaluate: Draw square: " + (grid.evaluate(squareDr, 0, 0, 1)==0));

        System.out.println();

        // Get children function
        ArrayList<Child> children = grid.getChildren(squareE, 1);
        System.out.println("Children for empty array");
        grid.displayChildren(children);

        System.out.println();

        // Best move functions
        System.out.println("Best move: Best move square: ");
        int[] bestmove = grid.bestMove(squareBMs, 1, 1, 1, 1,7);
        int row = bestmove[0];
        int col = bestmove[1];
        int score = bestmove[2];
        System.out.println("row: "+row+" col: "+col+" score: "+score);

        System.out.println("Best move: Empty square: ");
        bestmove = grid.bestMove(squareE, 1, 1, 1, 1, 1);
        row = bestmove[0];
        col = bestmove[1];
        score = bestmove[2];
        System.out.println("row: "+row+" col: "+col+" score: "+score);

        System.out.println("Best move: 3rd move square: ");
        bestmove = grid.bestMove(squareBM3, 1, 1, 1, 1, 3);
        row = bestmove[0];
        col = bestmove[1];
        score = bestmove[2];
        System.out.println("row: "+row+" col: "+col+" score: "+score);
    }
}
