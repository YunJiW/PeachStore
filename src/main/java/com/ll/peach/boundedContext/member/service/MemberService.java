package com.ll.peach.boundedContext.member.service;

import com.ll.peach.base.rsData.RsData;
import com.ll.peach.boundedContext.address.Address;
import com.ll.peach.boundedContext.member.entity.Member;
import com.ll.peach.boundedContext.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public RsData<Member> join(String username, String password, String phone, String sido, String roadAddress, String zonecode) {
        Member findMember = findByUsername(username);
        if (findMember != null) {
            return RsData.of("F-1", "이미 존재하는 회원입니다.", findMember);
        }

        Member member = Member.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .phone(phone)
                .address(new Address(sido, roadAddress, zonecode))
                .build();


        memberRepository.save(member);

        return RsData.of("S-1", "회원가입 완료", member);

    }


    public Member findByUsername(String username) {
        return memberRepository.findByUsername(username).orElse(null);
    }
}
