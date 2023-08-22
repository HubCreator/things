package thigns.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import thigns.repository.MemberCredentialsRepository;
import thigns.repository.MemberRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberCredentialsTest {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberCredentialsRepository memberCredentialsRepository;

    @Test
    void test() {
        //given
        Member member = new Member("hubcreator");
        memberRepository.save(member);

        MemberCredentials credentials = new MemberCredentials(member, "testToken");
        memberCredentialsRepository.save(credentials);

        memberRepository.flush();
        memberCredentialsRepository.flush();

        //when
        MemberCredentials findMemberCredentials = memberCredentialsRepository.findByMemberId(member.getId());

        //then
        assertThat(findMemberCredentials.getToken()).isEqualTo("testToken");
    }
}
