package calculator.domain;

public class Calculator {

    // 양수의 합
    public int sum(String input) {
        String[] numbers = split(input);

        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }

    // 기본 구분자로 구분하기
    private String[] split(String input) {
        return input.split(",|:");
    }
}
