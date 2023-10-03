package thigns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import thigns.domain.Book;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitle(String book);
    new JdbcTemplate

    @Override
    @Query("delete from Book b where b = :book")
    void delete(@Param("book") Book book);
}
