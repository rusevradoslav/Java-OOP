package core;

import core.interfaces.PilotFactory;
import entities.PilotImpl;
import entities.interfaces.Pilot;

public class PilotFactoryImpl implements PilotFactory {

    @Override
    public Pilot createPilot(String name) {
        Pilot pilot = new PilotImpl(name);
        return pilot;
    }
}
