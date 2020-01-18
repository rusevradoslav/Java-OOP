package RandomArrayList_03;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {
    public T getRandomElement() {
        int randomIndex = this.getRandomIndex();

        return super.remove(randomIndex);
    }

    private int getRandomIndex() {
        Random random = new Random();
        int index = random.nextInt(super.size());
        return index;
    }

}
