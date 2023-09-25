package thigns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thigns.domain.MemberCredentials;

public interface MemberCredentialsRepository extends JpaRepository<MemberCredentials, Long> {
    MemberCredentials findByMemberId(Long memberId);
}
