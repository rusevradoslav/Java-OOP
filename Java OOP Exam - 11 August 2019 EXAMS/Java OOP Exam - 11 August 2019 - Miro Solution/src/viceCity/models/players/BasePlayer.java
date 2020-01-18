package viceCity.models.players;

import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.GunRepository;
import viceCity.repositories.interfaces.Repository;

import static viceCity.common.ExceptionMessages.*;

public abstract class BasePlayer implements Player {
    private String name;
    private int lifePoints;
    private Repository<Gun> gunRepository;

    public BasePlayer(String name, int lifePoints) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.gunRepository  = new GunRepository();
    }

    private void setName(String name) {
        if(name!=null && !name.trim().isEmpty()) {
            this.name = name;
        }else{
            throw new NullPointerException(PLAYER_NULL_USERNAME);
        }
    }

    protected void setLifePoints(int lifePoints) {
        if(lifePoints>=0) {
            this.lifePoints = lifePoints;
        }else{
            throw new NullPointerException(PLAYER_LIFE_POINTS_LESS_THAN_ZERO);
        }
    }

    @Override
    public Repository<Gun> getGunRepository() {
        return this.gunRepository;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLifePoints() {
        return this.lifePoints;
    }

    @Override
    public void takeLifePoints(int points){
        if(this.lifePoints-points<0){
            this.lifePoints = 0;
        }else{
            lifePoints -= points;
        }
    }

    @Override
    public boolean isAlive() {
        return this.lifePoints>0;
    }
}
