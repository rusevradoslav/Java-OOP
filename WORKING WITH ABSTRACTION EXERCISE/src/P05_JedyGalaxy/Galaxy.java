package P05_JedyGalaxy;

public class Galaxy {
    private Star[][] stars;

    public Galaxy(int rows, int cols) {
        this.stars = new Star[rows][cols];
        this.fillStars();
    }

    public int getStarValue(int row, int col) {
        return stars[row][col].getValue();
    }

    public void fillStars() {
        int counter = 0;
        for (int i = 0; i < stars.length; i++) {
            for (int j = 0; j < stars[i].length; j++) {
                stars[i][j] = new Star(counter++);
            }
        }
    }

    public void evilStar(int row, int col) {
        this.stars[row][col] = new Star(0);
    }

    public boolean isValid(int row, int col) {
        if (row < 0 || row > this.stars.length - 1 || col < 0 || col > this.stars[0].length - 1) {
            return false;
        }
        return true;
    }

    public int gerRowLength() {
        return stars.length;
    }

    public int getColLength() {
        return stars[0].length;
    }

}
