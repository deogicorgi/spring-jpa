package io.github.deogicorgi.spring.jpa.service;

import io.github.deogicorgi.spring.jpa.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Test
    @DisplayName("Member find test")
    void findById() {

        Member member = memberService.findById(1);

        assertEquals(member.getId(), 1);
        assertEquals(member.getName(), "Jennie");
        assertEquals(member.getTeam().getName(), "BlackPink");

        System.out.println(member);
    }

}