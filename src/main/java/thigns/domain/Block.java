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

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "page_id")
    private Page page;
    /*@ManyToOne
    @JoinColumn(name = "parent_id")
    private Block parent;
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Block> children = new ArrayList<>();*/
    @Enumerated(EnumType.STRING)
    private Type type;
    @OneToMany(mappedBy = "block", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Text> texts = new ArrayList<>();

    public Block(final String content) {
        this.type = Type.of(content);
        Map<Style, int[]> map = new HashMap<>();
        final List<Style> entry = Style.entry(content);
        for (Style style : entry) {
            final String subString = style.getPattern().matcher(content).pattern().toString();
            final int startIndex = content.indexOf(subString);
            map.put(style, new int[]{startIndex, startIndex + subString.length()});
        }
        // TODO : 스타일별로 구간을 끊었는데, 이걸 Text로 어케 변환함?
    }

    public void setPage(final Page page) {
        this.page = page;
    }
}
