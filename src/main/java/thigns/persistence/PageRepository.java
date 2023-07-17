package thigns.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import thigns.domain.Writing;

public interface PageRepository extends JpaRepository<Writing, Long> {
}
