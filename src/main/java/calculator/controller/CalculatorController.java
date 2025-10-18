package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.Separator;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class CalculatorController {

    private final Separator separator = new Separator();
    private final Calculator calculator = new Calculator();

    public void run() {
        try {
            String input = InputView.readInput();
            List<String> numbers = separator.split(input);
            int result = calculator.calculateSum(numbers);
            OutputView.printResult(result);
        } catch (IllegalArgumentException e) {
            System.out.println("입력 오류: " + e.getMessage());
        }
    }
}
