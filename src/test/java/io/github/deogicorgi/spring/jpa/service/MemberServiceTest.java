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
        member.setId("deogicorgi");
        member.setUsername("더기코기");
        member.setAge(33);

        Member save = memberService.save(member);

        assertEquals("deogicorgi", save.getId());
        assertEquals("더기코기", save.getUsername());
        assertEquals(33, save.getAge());
    }
}