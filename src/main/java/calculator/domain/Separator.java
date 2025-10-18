package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {

    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.+)\\n(.*)");

    public List<String> split(String input) {
        if (input == null || input.isBlank()) {
            return List.of("0");
        }

        // 문자열로 들어온 "\n"을 실제 줄바꿈으로 변환
        input = input.replace("\\n", "\n");

        Matcher matcher = CUSTOM_PATTERN.matcher(input);

        if (matcher.matches()) {
            String customDelimiter = matcher.group(1);
            String numbers = matcher.group(2);

            // 커스텀 구분자는 메타문자 안전 처리
            return Arrays.asList(numbers.split(Pattern.quote(customDelimiter)));
        }

        // 기본 구분자(, 또는 :)로 분리
        return Arrays.asList(input.split(DEFAULT_DELIMITERS));
    }
}

