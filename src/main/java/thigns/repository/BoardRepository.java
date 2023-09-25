package thigns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thigns.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
