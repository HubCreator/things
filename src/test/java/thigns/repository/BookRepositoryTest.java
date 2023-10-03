package thigns.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import thigns.domain.Book;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    EntityManager em;

    @Test
    void deleteTest () {
        //given
        Book book = new Book("book");
        bookRepository.save(book);
        em.flush();
        em.clear();

        //when
        bookRepository.delete(book);
        em.flush();
        em.clear();

        //then
        assertThat(bookRepository.findByTitle("book")).isEmpty();
    }

}
