package io.github.deogicorgi.spring.jpa.service;

import io.github.deogicorgi.spring.jpa.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Test
    void save(){
        Member member = new Member();
        member.setId("강원덕");
        member.setUsername("kangwding");
        member.setAge(33);

        Member save = memberService.save(member);

        assertEquals("강원덕", save.getId());
        assertEquals("kangwding", save.getUsername());
    }
}