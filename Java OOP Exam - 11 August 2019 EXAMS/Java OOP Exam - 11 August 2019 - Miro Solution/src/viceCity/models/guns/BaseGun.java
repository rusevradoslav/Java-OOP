package viceCity.models.guns;

import static viceCity.common.ExceptionMessages.*;

public abstract class BaseGun implements Gun {
    private String name;
    private int bulletsPerBarrel;
    private int totalBullets;

    public BaseGun(String name, int bulletsPerBarrel, int totalBullets) {
        this.setName(name);
        this.setBulletsPerBarrel(bulletsPerBarrel);
        this.totalBullets = totalBullets;
    }

    private void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new NullPointerException(NAME_NULL);
        }
    }

    protected void setBulletsPerBarrel(int bulletsPerBarrel) {
        if (bulletsPerBarrel >= 0) {
            this.bulletsPerBarrel = bulletsPerBarrel;
        } else {
            throw new NullPointerException(BULLETS_LESS_THAN_ZERO);
        }
    }

    protected void setTotalBullets(int totalBullets) {
        if (totalBullets >= 0) {
            this.totalBullets = totalBullets;
        } else {
            throw new NullPointerException(TOTAL_BULLETS_LESS_THAN_ZERO);
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBulletsPerBarrel() {
        return this.bulletsPerBarrel;
    }

    @Override
    public boolean canFire() {
        return this.bulletsPerBarrel > 0 || this.totalBullets > 0;
    }

    @Override
    public int getTotalBullets() {
        return this.totalBullets;
    }

}
