package thigns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thigns.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByMemberName(String memberName);
//    Member findByName(String name);
}
