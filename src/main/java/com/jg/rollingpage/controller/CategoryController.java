package com.jg.rollingpage.controller;

import com.jg.rollingpage.domain.Category;
import com.jg.rollingpage.domain.CategoryDTO;
import com.jg.rollingpage.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<Object> createCategory(CategoryDTO category){
        categoryService.createCategory(category);
        return new ResponseEntity(HttpStatus.OK);
    }
}
