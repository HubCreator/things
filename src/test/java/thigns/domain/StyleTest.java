package thigns.domain;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

class StyleTest {

    Pattern pattern = Pattern.compile("\\*\\*(.*?)\\*\\*");

    @Test
    void name() {
        // given
        final String text = "**안    `  ** `**                녕**하세요**안녕**";

        // when
        final List<String> result = pattern.matcher(text)
            .results()
            .map(MatchResult::group)
            .toList();

        // then
        for (String matchResult : result) {
            System.out.println(matchResult);
        }
    }
}
