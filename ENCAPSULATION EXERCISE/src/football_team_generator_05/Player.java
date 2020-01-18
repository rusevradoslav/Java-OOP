package football_team_generator_05;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEndurance(int endurance) {
        validateSkill("Endurance", endurance);
        this.endurance = endurance;
    }


    public void setSprint(int sprint) {
        validateSkill("Sprint", sprint);
        this.sprint = sprint;
    }

    public void setDribble(int dribble) {
        validateSkill("Dribble", dribble);
        this.dribble = dribble;
    }

    public void setPassing(int passing) {
        validateSkill("Passing", passing);
        this.passing = passing;
    }

    public void setShooting(int shooting) {
        validateSkill("Shooting", shooting);
        this.shooting = shooting;
    }

    private void validateSkill(String skill, int value) {
        if (value < 1 || value > 100) {
            throw new IllegalArgumentException(String.format("%s should be between 0 and 100.", skill));
        }
    }

    public double overallSkills() {
        return (this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / 5.0;
    }

}
