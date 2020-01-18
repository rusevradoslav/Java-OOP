package military_elite_04.military.entities;

import military_elite_04.military.interfaces.Spy;

public class SpyImpl extends SoldierImpl implements Spy {
    private String codeNumber;

    public SpyImpl(int id, String name, String lastName, String codeNumber) {
        super(id, name, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator());
        sb.append(String.format("Code Number: %s", this.codeNumber));
        return sb.toString().trim();
    }
}
