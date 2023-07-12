package thigns.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StyleRange {

    private int startIndex;
    private int endIndex;

    public StyleRange(final int startIndex) {
        this.startIndex = startIndex;
    }
}
