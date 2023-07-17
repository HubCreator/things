package thigns.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Block {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writing_id")
    private Writing writing;
    /*@ManyToOne
    @JoinColumn(name = "parent_id")
    private Block parent;
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Block> children = new ArrayList<>();*/
    @Enumerated(EnumType.STRING)
    private BlockType blockType;
    @OneToMany(mappedBy = "block", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Text> texts = new ArrayList<>();

    public Block(final String content) {
        this.blockType = BlockType.of(content);

        // <어떤 스타일, [startIndex, endIndex]>
        final Map<StyleRange, Style> map = new HashMap<>();
        final List<Style> entry = Style.entry(content);

        for (final Style style : entry) {
            final String subString = style.getPattern().matcher(content).pattern().toString();
            final int startIndex = content.indexOf(subString);
            final StyleRange styleRange = new StyleRange(startIndex + 1, startIndex + subString.length() - 1);
            map.put(styleRange, style);
        }

        for (int i = 0; i < content.length(); i++) {
            final StyleRange target = new StyleRange(content.charAt(i));
            if (map.containsKey(target)) {
                
            }
        }
    }

    public void setWriting(final Writing writing) {
        this.writing = writing;
    }
}

/**
 * 안녕하세요. `*저*는 **우아한테크코스 5기 _수료생_ 헙크입니다.**`
 */
