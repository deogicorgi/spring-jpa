package io.github.deogicorgi.spring.jpa.repository;

import io.github.deogicorgi.spring.jpa.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
// @AutoConfigureTestDatabase 어노테이션의 기본 설정은 Replace.Any이며 기본적으로 내장된 임베디드 데이터베이스를 사용한다.
// Replace.NONE로 설정하면 @ActiveProfiles에 해당하는 데이터 소스가 적용되며, 환경설정으로 세팅하려면 spring.test.database.replace: NONE으로 설정하면 된다.
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("Member Save Test")
    void memberSaveTest(){

        // given
        Member member = new Member();
        member.setId("deogicorgi");
        member.setUsername("더기코기");
        member.setAge(33);

        // when
        Member save = memberRepository.save(member);

        // then
        assertEquals("deogicorgi", save.getId());
        assertEquals("더기코기", save.getUsername());
        assertEquals(33, save.getAge());
    }

    @Test
    @DisplayName("Member Update Test")
    void memberUpdateTest(){

        // given
        Member member = new Member();
        member.setId("deogicorgi");
        member.setUsername("더기코기");
        member.setAge(33);

        Member save = memberRepository.save(member);

        // when
        save.setUsername("더기코기2");
        save.setAge(34);

        Member updated = memberRepository.save(save);

        // then
        assertEquals("deogicorgi", save.getId());
        assertEquals("더기코기2", save.getUsername());
        assertEquals(34, save.getAge());
    }

}