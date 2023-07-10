package thigns.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import thigns.domain.Text;

public interface TextRepository extends JpaRepository<Text, Long> {
}
