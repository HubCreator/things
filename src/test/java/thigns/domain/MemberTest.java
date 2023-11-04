package thigns.domain;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class MemberTest {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private EntityManager em;

    @Test
    void flushTest() {
        Member member = memberRepository.save(new Member("member"));

        em.flush();
        em.clear();

        Member findMember = memberRepository.findById(member.getId()).orElseThrow();
        findMember.updateName("update");
        teamRepository.bulkQuery();
        System.out.println("==================");
    }
}