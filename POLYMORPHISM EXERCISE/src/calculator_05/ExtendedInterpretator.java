package calculator_05;

import java.util.ArrayDeque;
import java.util.Deque;

public class ExtendedInterpretator extends InputInterpreter {
    private Deque<Integer> memory;

    public ExtendedInterpretator(CalculationEngine engine) {
        super(engine);
        this.memory = new ArrayDeque<>();
    }

    @Override
    public Operation getOperation(String operand) {
        Operation operation = super.getOperation(operand);
        if (operation == null) {
            if (operand.equals("/")) {
                return new DivisionOperation();
            } else if (operand.equals("ms")) {
                return new MemorySaveOperations(this.memory);
            } else if (operand.equals("mr")) {
                return new MemoryRecallOperation(this.memory);
            }
        }
        return operation;
    }
}
