package repositories;

import models.players.interfaces.Player;
import repositories.interfaces.PlayerRepository;

import java.util.ArrayList;
import java.util.List;

import static common.ConstantMessages.*;

public class PlayerRepositoryImpl implements PlayerRepository {
    private List<Player> players;

    public PlayerRepositoryImpl() {
        this.players = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.players.size();
    }

    @Override
    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public void add(Player player) {
         if(player==null){
             throw new IllegalArgumentException(PLAYER_IS_NULL);
         }
         for (Player p: this.players){
             if(p.getUsername().equals(player.getUsername())){
                 throw new IllegalArgumentException(String.format(PLAYER_EXIST,player.getUsername()));
             }
         }
         this.players.add(player);
    }

    @Override
    public boolean remove(Player player) {
        if(player==null){
            throw new IllegalArgumentException(PLAYER_IS_NULL);
        }
        for (Player p: this.players){
            if(p.getUsername().equals(player.getUsername())){
                this.players.remove(p);
                return true;
            }
        }
        return false;
    }

    @Override
    public Player find(String name) {
        for (Player p: this.players){
            if(p.getUsername().equals(name)){
                return p;
            }
        }
        return null;
    }
}
