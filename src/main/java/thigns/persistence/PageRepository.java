package thigns.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import thigns.domain.Page;

public interface PageRepository extends JpaRepository<Page, Long> {
}
