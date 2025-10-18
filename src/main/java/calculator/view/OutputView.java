package calculator.view;

public class OutputView {
    private final static String CALC_RESULT_MESSAGE = "결과 : ";

    public static void printResult(int sum) {
        System.out.print(CALC_RESULT_MESSAGE + sum);
    }
}
