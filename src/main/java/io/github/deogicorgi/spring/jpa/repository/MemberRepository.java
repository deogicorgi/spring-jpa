package io.github.deogicorgi.spring.jpa.repository;

import io.github.deogicorgi.spring.jpa.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
}
