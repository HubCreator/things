package thigns.repository;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import thigns.domain.Board;
import thigns.domain.Tag;

import java.util.List;

@DataJpaTest
class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private EntityManager em;

    @Test
    void test() {
        //given
        Board boardA = new Board("boardA");
        Tag tag1 = new Tag("tag1", boardA);
        Tag tag2 = new Tag("tag2", boardA);
        Tag tag3 = new Tag("tag3", boardA);

        //when
//        boardRepository.save(boardA);
        tagRepository.saveAll(List.of(tag1, tag2, tag3));
        em.flush();
        em.clear();

        //then
        System.out.println("=========================");
        tagRepository.delete(tag1);
        em.flush();
    }
}
