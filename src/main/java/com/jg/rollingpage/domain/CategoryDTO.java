package com.jg.rollingpage.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDTO {

    private Integer categoryId;
    private String categoryName;
    private Integer categoryYear;
    private Date openAt;
    private String useAt;
    private LocalDateTime createAt;

    @Builder
    public CategoryDTO(Integer categoryId, String categoryName, Integer categoryYear, Date openAt, String useAt, LocalDateTime createAt) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryYear = categoryYear;
        this.openAt = openAt;
        this.useAt = useAt;
        this.createAt = createAt;
    }

    public static CategoryDTO entityToDTO(Category category){
        return CategoryDTO.builder()
                .categoryId(category.getCategoryId())
                .categoryName(category.getCategoryName())
                .categoryYear(category.getCategoryYear())
                .openAt(category.getOpenAt())
                .useAt(category.getUseAt())
                .createAt(category.getCreateAt())
                .build();
    }

    public static Category DTOToEntity(CategoryDTO categoryDTO){
        return Category.builder()
                .categoryId(categoryDTO.categoryId)
                .categoryName(categoryDTO.categoryName)
                .categoryYear(categoryDTO.categoryYear)
                .useAt(categoryDTO.useAt)
                .createAt(categoryDTO.createAt)
                .build();
    }
}
