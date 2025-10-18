package calculator.domain;

import java.util.regex.Pattern;

public class Separator {

    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.+)\\n(.*)");
    
}
