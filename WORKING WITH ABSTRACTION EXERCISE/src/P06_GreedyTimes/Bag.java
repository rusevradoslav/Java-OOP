package P06_GreedyTimes;

import java.util.HashMap;
import java.util.Map;

public class Bag {
    private long capacity;
    private long currentCapacity;
    private long gold;
    private Map<String, Long> gems;
    private long totalGems;
    private Map<String, Long> cash;
    private long totalCash;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.currentCapacity = 0;
        this.gold = 0;
        this.gems = new HashMap<>();
        this.totalGems = 0;
        this.cash = new HashMap<>();
        this.totalCash = 0;

    }

    public void addCash(String item, long weight) {
        if (hasFreeCapcity(weight) && this.totalGems >= this.totalCash + weight) {
            if (!this.cash.containsKey(item)) {
                this.cash.put(item, weight);
            } else {
                cash.put(item, cash.get(item) + weight);
            }
            this.currentCapacity += weight;
            this.totalCash += weight;
        }
    }

    private boolean hasFreeCapcity(long weight) {
        return this.currentCapacity + weight <= this.capacity;
    }

    public void addGem(String item, long weight) {
        if (hasFreeCapcity(weight) && this.gold >= this.totalGems + weight) {
            if (!this.gems.containsKey(item)) {
                this.gems.put(item, weight);
            } else {
                this.gems.put(item, this.gems.get(item) + weight);
            }
            this.currentCapacity += weight;
            this.totalGems += weight;
        }
    }

    public void addGold(long weight) {
        if (this.hasFreeCapcity(weight)) {
            this.gold += weight;
            this.currentCapacity += weight;
        }

    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<Gold> $").append(this.gold).append(System.lineSeparator());
        sb.append("##Gold - ").append(this.gold).append(System.lineSeparator());
        if (this.gems.size() > 0) {
            sb.append("<Gem> $").append(this.totalGems).append(System.lineSeparator());

            this.gems.entrySet().stream().sorted((f, s) -> {
                int result = s.getKey().compareTo(f.getKey());
                if (result == 0) {
                    result = f.getValue().compareTo(s.getValue());
                }
                return result;
            }).forEach(entry -> {
                sb.append("##").append(entry.getKey()).append(" - ").append(entry.getValue()).append(System.lineSeparator());
            });
        }
        if (this.cash.size() > 0) {
            sb.append("<Cash> $").append(this.totalCash).append(System.lineSeparator());

            this.cash.entrySet().stream().sorted((f, s) -> {
                int result = s.getKey().compareTo(f.getKey());
                if (result == 0) {
                    result = f.getValue().compareTo(s.getValue());
                }
                return result;
            }).forEach(entry -> {
                sb.append("##").append(entry.getKey()).append(" - ").append(entry.getValue()).append(System.lineSeparator());
            });
        }
        return sb.toString();
    }

}
