package com.ll.peach.base;

import com.ll.peach.base.rsData.RsData;
import com.ll.peach.boundedContext.category.entity.Category;
import com.ll.peach.boundedContext.category.service.CategoryService;
import com.ll.peach.boundedContext.item.entity.ItemType;
import com.ll.peach.boundedContext.item.service.ItemService;
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
            MemberService memberService,
            CategoryService categoryService,
            ItemService itemService
    ) {
        return args -> {
            RsData<Member> admin = memberService.join("admin", "1234", "01012345678", "adminssss", "관리자주소", "55482");

            RsData<Category> peach1 = categoryService.createCategory("천중도");
            RsData<Category> peach2 = categoryService.createCategory("백천");
            RsData<Category> peach3 = categoryService.createCategory("몽부사");
            RsData<Category> peach4 = categoryService.createCategory("그레이트");
            
            itemService.createItem("test1", ItemType.WHITE,35000,10,peach1.getData());
            itemService.createItem("test2", ItemType.WHITE,20000,10,peach2.getData());
            itemService.createItem("peaches", ItemType.YELLOW,40000,10,peach3.getData());
            itemService.createItem("peach", ItemType.WHITE,45000,10,peach4.getData());

        };
    }
}
