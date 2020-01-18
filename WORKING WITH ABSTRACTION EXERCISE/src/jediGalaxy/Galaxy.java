package jediGalaxy;

public class Galaxy {
    private Star[][] star;

    public Galaxy(int row, int col) {
        this.star = new Star[row][col];
        this.fillMatrix();
    }

    public int getStarValue(int row, int col) {
        return star[row][col].getValue();
    }

    private void fillMatrix() {
        int value = 0;
        for (int i = 0; i < star.length; i++) {
            for (int j = 0; j < star[i].length; j++) {
                star[i][j] = new Star(value++);
            }
        }
    }

    public void enemyStar(int row, int col) {
        this.star[row][col] = new Star(0);
    }

    public boolean isValid(int row, int col) {
        if (row < 0 || row > this.star.length - 1 || col < 0 || col > this.star[0].length - 1) {
            return false;
        }
        return true;
    }

    public int gerRowLength() {
        return star.length;
    }

    public int getColLength() {
        return star[0].length;
    }


}
