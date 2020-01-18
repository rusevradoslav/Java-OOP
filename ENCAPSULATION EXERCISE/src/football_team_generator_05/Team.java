package football_team_generator_05;

import java.util.ArrayList;
import java.util.List;

import static someValidations.Validator.validateName;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(String name) {
        boolean isRemoved = false;

        for (Player player : players) {
            if (player.getName().equals(name)) {
                players.remove(player);
                isRemoved = true;
                break;
            }
        }
        if (!isRemoved) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", name, this.name));
        }
    }

    public double getRatting() {
        return Math.round(players.stream().mapToDouble(Player::overallSkills).sum());
    }
}


