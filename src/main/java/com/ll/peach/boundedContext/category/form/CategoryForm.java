package com.ll.peach.boundedContext.category.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CategoryForm {

    @NotBlank
    @Size(max = 10)
    private String name;
}
