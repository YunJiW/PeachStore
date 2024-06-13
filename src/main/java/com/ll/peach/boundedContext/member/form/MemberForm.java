package com.ll.peach.boundedContext.member.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class MemberForm {

    @NotBlank
    @Size(min = 4, max = 20)
    private String username;

    @NotBlank
    @Size(min = 4, max = 30)
    private String password;

    @Size(max = 11)
    private String phone;

    private String sido;

    private String roadAddress;

    @Size(max = 5)
    private String zonecode;


}
