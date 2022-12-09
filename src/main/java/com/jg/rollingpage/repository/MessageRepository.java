package com.jg.rollingpage.repository;


import com.jg.rollingpage.domain.Message;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    // 메세지 목록 첫번째 페이지
    Slice<Message> findAllByUserUserIdAndCategoryCategoryIdAndDeleteAt(Integer userId, Integer categoryId, String deleteAt, Pageable pageable);

    // 메세지 목록 다음 페이지
    Slice<Message> findAllByUserUserIdAndCategoryCategoryIdAndDeleteAtAndMessageIdLessThan(Integer userId, Integer catagoryId, String deleteAt, Integer messageId, Pageable pageable);
}
