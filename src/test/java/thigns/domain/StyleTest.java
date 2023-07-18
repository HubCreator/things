package thigns.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Test
    @DisplayName("chunkTest")
    void chunk() {
        String input = """
                    ## 안녕하세요
                    안녕
                    ```java
                    psvm () {
                    }
                    ```
                    ### 최대분리수
                    #### 다섯개는?
                """;

        Pattern pattern = Pattern.compile("(?s)(```.*?```).*?|(.*?)(?=```|\\z)");
        Matcher matcher = pattern.matcher(input);

        List<String> list = new ArrayList<>();

        while(matcher.find()) {
            if (matcher.group(1) != null && !matcher.group(1).trim().isEmpty()) {
                list.add(matcher.group(1).trim());
            } else if (matcher.group(2) != null && !matcher.group(2).trim().isEmpty()) {
                String[] lines = matcher.group(2).trim().split("\\n");
                for (String line : lines) {
                    if (!line.trim().isEmpty()) {
                        list.add(line.trim());
                    }
                }
            }
        }
        System.out.println("list.size() = " + list.size());
        for (String s : list) {
            System.out.println("s = " + s);
        }
    }
}
