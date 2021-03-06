package viceCity.models.guns;

public class Rifle extends BaseGun {
    private static final int BULLETS_PER_BARREL = 50;
    private static final int TOTAL_BULLETS = 500;
    private static final int SHOUTED_BULLETS = 5;

    public Rifle(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {

        if (this.getBulletsPerBarrel() == 0) {
            reload();
            if (this.getBulletsPerBarrel() == 0) {
                this.setBulletsPerBarrel(0);
            }
        } else {
            this.setBulletsPerBarrel(this.getBulletsPerBarrel() - SHOUTED_BULLETS);
        }

        return SHOUTED_BULLETS;
    }

    private void reload() {
        if (this.getTotalBullets() - BULLETS_PER_BARREL >= 0) {
            //proboina
            this.setBulletsPerBarrel(BULLETS_PER_BARREL);
            this.setTotalBullets(this.getTotalBullets() - BULLETS_PER_BARREL);
        } else {
            this.setTotalBullets(0);

        }
    }
}
