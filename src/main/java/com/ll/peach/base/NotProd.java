package com.ll.peach.base;

import com.ll.peach.base.rsData.RsData;
import com.ll.peach.boundedContext.member.entity.Member;
import com.ll.peach.boundedContext.member.service.MemberService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"dev","test"})
public class NotProd {

    @Bean
    CommandLineRunner initData(
            MemberService memberService
    ) {
        return args -> {
            RsData<Member> admin = memberService.join("admin", "1234", "01012345678", "adminssss", "관리자주소", "55482");
        };
    }
}
