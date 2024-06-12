package com.ll.peach.boundedContext.member.controller;

import com.ll.peach.base.rsData.RsData;
import com.ll.peach.boundedContext.member.entity.Member;
import com.ll.peach.boundedContext.member.form.MemberForm;
import com.ll.peach.boundedContext.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/v1/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @PreAuthorize("isAnonymous()")
    @PostMapping("/join")
    public RsData<Member> join(@Valid @RequestBody MemberForm memberForm) {

        log.info("회원가입 시도");
        RsData<Member> Rs = memberService.join(memberForm.getUsername(),memberForm.getPassword(),memberForm.getPhone(),memberForm.getSido(),memberForm.getRoadAddress(),memberForm.getZonecode());

        if (Rs.isFail()) {
            return RsData.of("F-1", "회원이 이미 존재합니다.");
        }

        return RsData.of("S-1", "회원가입 완료", Rs.getData());
    }
}
