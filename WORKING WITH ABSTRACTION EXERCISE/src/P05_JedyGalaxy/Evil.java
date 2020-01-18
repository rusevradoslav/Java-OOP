package P05_JedyGalaxy;

public class Evil extends Hero {
   public Evil(int row,int col){
       super(row,col);
   }

    public void moveEvil() {
        this.row--;
        this.col--;
    }

}
