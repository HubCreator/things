package thigns.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Writing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "page", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Block> blocks = new ArrayList<>();

    public Writing(final String markdown) {
        final StringTokenizer st = new StringTokenizer(markdown, "\n");
        while (st.hasMoreTokens()) {
            final Block block = new Block(st.nextToken());
            block.setWriting(this);
            blocks.add(block);
        }
    }
}
