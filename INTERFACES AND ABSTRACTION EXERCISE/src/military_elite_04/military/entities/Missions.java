package military_elite_04.military.entities;

import military_elite_04.military.enumerations.State;

public class Missions {
    private String codeName;
    private State state;

    public Missions(String codeName, State state) {
        this.codeName = codeName;
        this.state = State.valueOf(state.toString());
    }

    public State getState() {
        return state;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append(String.format("Code Name: %s State: %s",
                this.codeName, this.getState()));
        return sb.toString();
    }

    public void setState() {
        this.state = State.Finished;
    }
}
