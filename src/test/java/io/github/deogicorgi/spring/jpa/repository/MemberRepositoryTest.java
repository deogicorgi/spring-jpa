package io.github.deogicorgi.spring.jpa.repository;

import io.github.deogicorgi.spring.jpa.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    void memberSaveTest(){
        Member member = new Member();
        member.setId("강원덕");
        member.setUsername("kangwding");
        member.setAge(33);

        Member save = memberRepository.save(member);

        assertEquals("강원덕", save.getId());
        assertEquals("kangwding", save.getUsername());

    }

}