package thigns.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import thigns.domain.Block;

public interface BlockRepository extends JpaRepository<Block, Long> {
}
