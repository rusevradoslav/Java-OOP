package hell.entities.miscellaneous.heroes;

import hell.interfaces.Hero;

import java.util.Comparator;

public class HeroesComparator implements Comparator<Hero> {

    @Override
    public  int compare(Hero o1, Hero o2) {
        long o1Sum = o1.getStrength() + o1.getAgility() + o1.getIntelligence();
        long o2Sum = o2.getStrength() + o2.getAgility() + o2.getIntelligence();

        if (o1Sum > o2Sum) {
            return 1;
        }
        if (o1Sum < o2Sum) {
            return -1;
        }

        o1Sum = o1.getHitPoints() + o1.getDamage();
        o2Sum = o2.getHitPoints() + o2.getDamage();
        return Long.compare(o1Sum, o2Sum);
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
