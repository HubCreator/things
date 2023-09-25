package thigns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thigns.domain.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
