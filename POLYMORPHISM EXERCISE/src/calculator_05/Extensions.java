package calculator_05;

public class Extensions {
    public static InputInterpreter buildInterpreter(CalculationEngine engine) {
        return new ExtendedInterpretator(engine);
    }
}
