package TrafficLights_04;

public class TrafficLight {
    private Signal signal;

    public TrafficLight(Signal signal) {
        this.signal = signal;
    }


    public void changeSignal() {
        switch (this.signal.name()) {
            case "RED":
                this.signal = Signal.GREEN;
                break;
            case "YELLOW":
                this.signal = Signal.RED;
                break;
            case "GREEN":
                this.signal = Signal.YELLOW;
                break;
        }
    }

    @Override
    public String toString() {
        return String.format("%s", signal.name());
    }
}
