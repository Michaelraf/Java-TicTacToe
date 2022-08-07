package model;

public class Child {
    private int[][] square;
    private int[] movePos;

    public Child(int[][]square, int[]movePos){
        this.square = square;
        this.movePos = movePos;
    }

    public Child(int len){
        this.square = new int[len][len];
        this.movePos = new int[2];
    }

    public void setSquare(int[][] square){
        this.square = square;
    }

    public void setSquare(int row, int col, int value){
        square[row][col] = value;
    }

    public void setMovePos(int row, int col){
        this.movePos[0] = row; 
        this.movePos[1] = col;
    }

    public void setMovePos(int[] movePos){
        this.movePos = movePos;
    }

    public int[][] getSquare(){
        return square;
    }

    public int[] getMovePos(){
        return movePos;
    }
}
