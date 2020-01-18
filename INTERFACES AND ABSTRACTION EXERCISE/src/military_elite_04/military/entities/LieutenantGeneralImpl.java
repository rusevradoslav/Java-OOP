package military_elite_04.military.entities;

import military_elite_04.military.interfaces.LieutenantGeneral;
import military_elite_04.military.interfaces.Private;

import java.util.TreeSet;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private TreeSet<Private> privates;

    public LieutenantGeneralImpl(int id, String name, String lastName, double salary) {
        super(id, name, lastName, salary);
        this.privates = new TreeSet<>((first, second) -> second.getId() - first.getId());
    }

    @Override
    public void addPrivate(Private priv) {
        privates.add(priv);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator());
        sb.append("Privates:");
        sb.append(System.lineSeparator());
        for (Private aPrivate : privates) {
            sb.append(aPrivate.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
