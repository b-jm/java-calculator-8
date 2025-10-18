package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @DisplayName("정상적인 숫자 리스트의 합을 계산한다.")
    @Test
    void calculateSum_basicCase() {
        List<String> numbers = List.of("1", "2", "3");
        int result = calculator.calculateSum(numbers);
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("빈 문자열은 0으로 처리하여 계산한다.")
    @Test
    void calculateSum_withEmptyString() {
        List<String> numbers = List.of("", "2", "3");
        int result = calculator.calculateSum(numbers);
        assertThat(result).isEqualTo(5);
    }

    @DisplayName("음수 입력 시 예외가 발생한다.")
    @Test
    void calculateSum_withNegativeNumber() {
        List<String> numbers = List.of("1", "-2", "3");

        assertThatThrownBy(() -> calculator.calculateSum(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수는 입력할 수 없습니다");
    }

    @DisplayName("숫자가 아닌 값이 포함되어 있으면 예외가 발생한다.")
    @Test
    void calculateSum_withInvalidString() {
        List<String> numbers = List.of("a", "2", "3");

        assertThatThrownBy(() -> calculator.calculateSum(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닌 값이 포함되어 있습니다");
    }

    @DisplayName("모든 입력이 빈 문자열이면 0을 반환한다.")
    @Test
    void calculateSum_allEmptyStrings() {
        List<String> numbers = List.of("", "", "");
        int result = calculator.calculateSum(numbers);
        assertThat(result).isEqualTo(0);
    }
}


