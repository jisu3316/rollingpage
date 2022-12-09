package com.jg.rollingpage.service;

import com.jg.rollingpage.domain.Category;
import com.jg.rollingpage.domain.CategoryDTO;
import com.jg.rollingpage.domain.Message;
import com.jg.rollingpage.domain.MessageDTO;
import com.jg.rollingpage.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional
    public void createCategory(CategoryDTO categoryDTO) {
        Category category = CategoryDTO.DTOToEntity(categoryDTO);
        categoryRepository.save(category.builder()
                        .categoryYear(category.getCategoryYear())
                        .categoryName("메리크리스마스")
                        .openAt(category.getOpenAt())
                        .useAt("Y")
                        .createAt(LocalDateTime.now())
                .build());
    }


}
