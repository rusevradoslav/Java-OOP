package jediGalaxy;

public class Enemy {
    private int row;
    private int col;


    public Enemy(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void moveEnemy() {
        row--;
        col--;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
