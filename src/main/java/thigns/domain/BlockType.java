package thigns.domain;

import lombok.Getter;

import java.util.Arrays;
import java.util.regex.Pattern;

@Getter
public enum BlockType {
    HEADING1("^#{1} "),
    HEADING2("^#{2} "),
    HEADING3("^#{3} "),
    BLOCK_QUOTE("`"),
    ORDERED_LIST("^-{1} "),
    UNORDERED_LIST("^[1-9][0-9]{0,4}\\. "),
    CODE_BLOCK("^(?=`{3})(?=`{3})$"),
    LINK("\\[[a-z0-9]*\\]\\(\\)"),
    TABLE("^\\|.*\\|$");

    private final Pattern pattern;

    BlockType(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    public static BlockType of(final String content) {
        return Arrays.stream(values())
                .filter(m -> m.getPattern().matcher(content).find())
                .findFirst()
                .orElseThrow();
    }
}
