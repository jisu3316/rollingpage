package com.jg.rollingpage.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@NoArgsConstructor
@Entity
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "category_id")
    private Integer categoryId;
    @Comment("")
    @Column(name = "category_name")
    private String categoryName;
    @Comment("")
    @Column(name = "category_year")
    private Integer categoryYear;
    @Comment("")
    @Column(name = "open_at")
    private Date openAt;
    @Comment("")
    @Column(name = "use_at")
    private String useAt;
    @Comment("")
    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Builder
    public Category(Integer categoryId, String categoryName, Integer categoryYear, Date openAt, String useAt, LocalDateTime createAt) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryYear = categoryYear;
        this.openAt = openAt;
        this.useAt = useAt;
        this.createAt = createAt;
    }
}
