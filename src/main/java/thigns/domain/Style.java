package thigns.domain;

import lombok.Getter;

@Getter
public enum Style {
    HEADER1("# "),
    HEADER2("## "),
    HEADER3("### "),
    LIST_UNORDERED("- "),
    LIST_ORDERED("- ");

    private final String style;

    Style(final String style) {
        this.style = style;
    }
}
