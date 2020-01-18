package cresla;

import cresla.entities.core.Engine;
import cresla.entities.core.EngineImpl;
import cresla.entities.core.ManagerImpl;

public class Main {
    public static void main(String[] args) {
        ManagerImpl manager = new ManagerImpl();
        Engine engine = new EngineImpl(manager);
        engine.run();
    }
}
