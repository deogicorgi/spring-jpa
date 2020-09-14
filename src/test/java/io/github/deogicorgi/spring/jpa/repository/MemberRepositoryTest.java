package io.github.deogicorgi.spring.jpa.repository;

import io.github.deogicorgi.spring.jpa.entity.Company;
import io.github.deogicorgi.spring.jpa.entity.Member;
import io.github.deogicorgi.spring.jpa.entity.Team;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    CompanyRepository companyRepository;

    @Test
    @DisplayName("Member save test")
    void save(){
        Company company = new Company();
        company.setName("YG Entertainment");
        Company savedCompany = companyRepository.save(company);

        Team team = new Team();
        team.setName("BlackPink");
        team.setCompany(savedCompany);
        Team savedTeam = teamRepository.save(team);

        Member member = new Member();
        member.setName("Jennie");
        member.setTeam(savedTeam);

        Member savedMember = memberRepository.save(member);
        System.out.println(savedMember);

    }
}