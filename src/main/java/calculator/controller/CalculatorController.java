package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    public void run() {
        InputView inputView = new InputView();
        String input = inputView.readInput();

        Calculator calculator = new Calculator();
        int sum = calculator.sum(input);

        OutputView outputView = new OutputView();
        outputView.printResult(sum);
    }
}
