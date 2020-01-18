package calculator_05;

import java.util.ArrayDeque;
import java.util.Deque;

public class MemorySaveOperations implements Operation {

    private Deque<Integer> memory;

    public MemorySaveOperations(Deque<Integer> memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {
        this.memory.push(operand);
    }

    @Override
    public int getResult() {
        return this.memory.peek();
    }

    @Override
    public boolean isCompleted() {
        return false;
    }
}
