package io.github.deogicorgi.spring.jpa.service;

import io.github.deogicorgi.spring.jpa.entity.Member;
import io.github.deogicorgi.spring.jpa.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member save(Member member){
        return memberRepository.save(member);
    }
}
