package viceCity.models.guns;

public class Rifle extends BaseGun {
    public Rifle(String name) {
        super(name, 50, 500);
    }

    @Override
    public int fire() {
        if (this.getBulletsPerBarrel() == 0) {
            reload();
        }
        if (this.getBulletsPerBarrel() == 0) {
            return 0;
        }
        this.setBulletsPerBarrel(this.getBulletsPerBarrel() - 5);
        return 5;
    }

    private void reload() {
        if (this.getTotalBullets() > 0) {
            this.setBulletsPerBarrel(50);
            this.setTotalBullets(this.getTotalBullets() - 50);
        }
    }
}
