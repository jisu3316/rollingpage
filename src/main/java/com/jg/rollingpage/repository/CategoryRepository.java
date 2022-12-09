package com.jg.rollingpage.repository;

import com.jg.rollingpage.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
