package P05_JedyGalaxy;

public class Hero {
    int row;
    int col;

    public Hero(int rowCoordinate, int colCoordinate) {
        this.row = rowCoordinate;
        this.col = colCoordinate;
    }

    public void moveHero() {
        row--;
        col++;
    }

    public int getRowCoordinate() {
        return row;
    }

    public int getColCoordinate() {
        return col;
    }

}
