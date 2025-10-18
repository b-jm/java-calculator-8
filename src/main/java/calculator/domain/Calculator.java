package calculator.domain;

import java.util.List;

public class Calculator {

    // 에러 메시지를 상수로 선언
    private static final String NEGATIVE_NUMBER_ERROR = "음수는 입력할 수 없습니다";
    private static final String INVALID_NUMBER_ERROR = "숫자가 아닌 값이 포함되어 있습니다";

    public int calculateSum(List<String> numbers) {
        int total = 0;

        for (String number : numbers) {
            int value = parsePositiveNumber(number);
            total += value;
        }

        return total;
    }

    private int parsePositiveNumber(String input) {
        // 빈 문자열 또는 null은 0으로 처리
        if (input == null || input.isBlank()) {
            return 0;
        }

        try {
            int value = Integer.parseInt(input.trim());

            if (value < 0) {
                throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR);
            }

            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_ERROR);
        }
    }
}
