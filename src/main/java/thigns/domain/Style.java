package thigns.domain;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Getter
public enum Style {

    BOLD("\\*\\*(.*?)\\*\\*"),
    ITALIC("\\*(.*?)\\*"),
    UNDERLINE("_([^_]+)_"),
    STRIKE_THROUGH("~~(.*?)~~"),
    COLOR("\\{color\\}(.*?)\\{color\\}"),
    INLINE_CODE("`([^`]+)`");

    private final Pattern pattern;

    Style(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    public static Style of(final String content) {
        return Arrays.stream(values())
                .filter(m -> m.getPattern().matcher(content).find())
                .findFirst()
                .orElseThrow();
    }

    public static List<Style> entry(final String content) {
        return Arrays.stream(values())
                .filter(m -> m.getPattern().matcher(content).find())
                .collect(Collectors.toList());
    }
}
