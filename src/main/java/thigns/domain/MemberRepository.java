package thigns.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("select m from Member m where m.id = 1")
    void myQuery();

    @Modifying
    @Query("update Member m set m.name = 'hubcreator'")
    void myBulkQuery();
}
