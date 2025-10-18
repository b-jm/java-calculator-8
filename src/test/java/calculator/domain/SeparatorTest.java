package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SeparatorTest {
    private final Separator separator = new Separator();

    @DisplayName("쉼표(,)와 콜론(:)으로 구분된 문자열을 분리한다.")
    @Test
    void split_withDefaultDelimiters() {
        List<String> result = separator.split("1,2:3");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @DisplayName("커스텀 구분자를 인식하여 문자열을 분리한다.")
    @Test
    void split_withCustomDelimiter() {
        List<String> result = separator.split("//;\\n1;2;3");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @DisplayName("입력이 비어있으면 0을 반환한다.")
    @Test
    void split_withEmptyInput() {
        List<String> result = separator.split("");
        assertThat(result).containsExactly("0");
    }

    @DisplayName("커스텀 구분자가 정규식 메타문자여도 안전하게 처리한다.")
    @Test
    void split_withMetaCharacterDelimiter() {
        List<String> result = separator.split("//.\\n1.2.3");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @DisplayName("커스텀 구분자 형식이 틀리면 기본 구분자로 분리한다.")
    @Test
    void split_withInvalidCustomDelimiterFormat() {
        List<String> result = separator.split("//;1;2;3");
        assertThat(result).containsExactly("//;1;2;3"); // 매칭 실패 → 전체 문자열 반환
    }
}
