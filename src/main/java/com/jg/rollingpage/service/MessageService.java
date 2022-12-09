package com.jg.rollingpage.service;

import com.jg.rollingpage.domain.Message;
import com.jg.rollingpage.domain.MessageDTO;
import com.jg.rollingpage.domain.User;
import com.jg.rollingpage.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    @Transactional
    public void createMessage(MessageDTO message) {
        System.out.println(message);
        messageRepository.save(Message.builder()
                .categoryId(message.getCategoryId())
                .userId(message.getUserId())
                .messageContents(message.getMessageContents())
                .senderNickname(message.getSenderNickname())
                .deleteAt("N")
                .createAt(LocalDateTime.now())
                .build());
    }

    // 메세지 목록 조회
    public Slice<Message> getMessageList(int userId, int catetoryId, int lastMessageId) {
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "messageId"));
        if(lastMessageId > 0){
            return messageRepository.findAllByUserUserIdAndCategoryCategoryIdAndDeleteAtAndMessageIdLessThan(userId, catetoryId, "N", lastMessageId, pageRequest);
        }else{
            return messageRepository.findAllByUserUserIdAndCategoryCategoryIdAndDeleteAt(userId, catetoryId, "N", pageRequest);
        }
    }
}
