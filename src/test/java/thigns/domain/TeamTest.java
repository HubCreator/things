package thigns.domain;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import thigns.repository.MemberRepository;
import thigns.repository.TeamRepository;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@Transactional
@SpringBootTest
class TeamTest {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private EntityManager em;

    @Test
    void save() {
        //given
        Member memberA = new Member("memberA");
        Member memberB = new Member("memberB");
        Team teamA = new Team("teamA", new ArrayList<>(List.of(memberA, memberB)));

        //when
        teamRepository.save(teamA);
        em.flush();
        em.clear();

        //then
        Team findTeam = teamRepository.findByTeamName("teamA").orElseThrow();
        assertAll(
                () -> assertThat(findTeam.getMembers()).hasSize(2),
                () -> assertThat(findTeam.getMembers().get(0)).isEqualTo(memberA),
                () -> assertThat(findTeam.getMembers().get(1)).isEqualTo(memberB)
        );
    }

    @Test
    void add() {
        //given
        Member memberA = new Member("memberA");
        Member memberB = new Member("memberB");
        Team teamA = new Team("teamA", new ArrayList<>(List.of(memberA, memberB)));
        Team savedTeam = teamRepository.save(teamA);

        //when
        Member memberC = new Member("memberC");
        savedTeam.getMembers().add(memberC);
        em.flush();
        em.clear();

        //then
        Team findTeam = teamRepository.findByTeamName("teamA").orElseThrow();
        assertAll(
                () -> assertThat(findTeam.getMembers()).hasSize(3),
                () -> assertThat(findTeam.getMembers().get(0)).isEqualTo(memberA),
                () -> assertThat(findTeam.getMembers().get(1)).isEqualTo(memberB),
                () -> assertThat(findTeam.getMembers().get(2)).isEqualTo(memberC)
        );
    }

    @Test
    void remove() {
        //given
        Member memberA = new Member("memberA");
        Member memberB = new Member("memberB");
        Team teamA = new Team("teamA", new ArrayList<>(List.of(memberA, memberB)));

        //when
        Team savedTeam = teamRepository.save(teamA);
        savedTeam.getMembers().remove(0);
        em.flush();
        em.clear();

        //then
        Team findTeam = teamRepository.findByTeamName("teamA").orElseThrow();
        assertThat(findTeam.getMembers()).hasSize(1);
    }

    @Test
    void update() {
        //given
        Member memberA = new Member("memberA");
        Member memberB = new Member("memberB");
        Team teamA = new Team("teamA", new ArrayList<>(List.of(memberA, memberB)));
        Team savedTeam = teamRepository.save(teamA);

        //when
        Member memberC = new Member("memberC");
        savedTeam.getMembers().set(0, memberC);
        em.flush();
        em.clear();

        //then
        Team findTeam = teamRepository.findByTeamName("teamA").orElseThrow();
        assertAll(
                () -> assertThat(findTeam.getMembers()).hasSize(2),
                () -> assertThat(findTeam.getMembers()).containsExactlyInAnyOrder(memberC, memberB)
        );
    }

    @Test
    void saveㅁㄴㅇㄹ() {
        Member memberA = new Member("memberA");
        Member memberB = new Member("memberB");
        Team team = new Team("teamA");
        team.add(memberA);
        team.add(memberB);

        teamRepository.save(team);
    }
}
