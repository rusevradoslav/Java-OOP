package viceCity.models.guns;

public class Rifle extends BaseGun {
    private static final int BULLETS_PER_BARREL = 50;
    private static final int TOTAL_BULLETS = 500;
    private static final int ZERO_BULLETS = 0;
    private static final int BULLETS_PER_SHOOT = 5;

    public Rifle(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }


    @Override
    public int fire() {
        if (this.getBulletsPerBarrel() == ZERO_BULLETS) {
            reload();
            if (this.getBulletsPerBarrel() == ZERO_BULLETS) {
                setBulletsPerBarrel(ZERO_BULLETS);
            }

        }
        this.setBulletsPerBarrel(getBulletsPerBarrel() - BULLETS_PER_SHOOT);

        return BULLETS_PER_SHOOT;
    }

    private void reload() {
        if (getTotalBullets() > ZERO_BULLETS) {
            setBulletsPerBarrel(BULLETS_PER_BARREL);
            setTotalBullets(getTotalBullets() - BULLETS_PER_BARREL);
        }else {
            setBulletsPerBarrel(ZERO_BULLETS);
        }
    }
}
