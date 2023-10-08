package thigns.repository;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.support.TransactionTemplate;
import thigns.domain.Member;
import thigns.domain.Team;

import java.util.List;

@SpringBootTest
class MemberSpringBootTest {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private TransactionTemplate template;
    @Autowired
    private EntityManager em;

    @Test
    void test() {
        //given
        template.executeWithoutResult(result -> {
            Member member1 = new Member("member1");
            Member member2 = new Member("member2");
            Member member3 = new Member("member3");
            Team teamA = new Team("teamA", List.of(member1, member2, member3));

            teamRepository.save(teamA);
        });

        System.out.println("============");

        //then
        template.executeWithoutResult(result -> {
            Member member3 = memberRepository.findByMemberName("member3");
            Member member2 = memberRepository.findByMemberName("member2");
            Member member1 = memberRepository.findByMemberName("member1");

            System.out.println("=====");

            member3.changeName("memberC");
            member2.changeName("memberB");
            member1.changeName("memberA");
        });
    }
}
