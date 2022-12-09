package com.jg.rollingpage.controller;

import com.jg.rollingpage.domain.Message;
import com.jg.rollingpage.domain.MessageDTO;
import com.jg.rollingpage.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class MessageController {

    private final MessageService messageService;

    // 메세지 등록
    @PostMapping("/message")
    public ResponseEntity<Object> createMessage(MessageDTO message){
        messageService.createMessage(message);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 메세지 목록 조회
    @GetMapping("/message")
    public ResponseEntity<List<MessageDTO>> getMessageList(int userId, int categoryId, int lastMessageId){

        Slice<Message> messages = messageService.getMessageList(userId,categoryId, lastMessageId);
        HttpHeaders header = new HttpHeaders();
        if(messages.hasNext()){
            header.add("nextRequest", "/message?userId=" + userId + "&categoryId=" + categoryId + "&lastMessageId=" + messages.getContent().get(messages.getSize()-1).getMessageId());
        }

        return new ResponseEntity<>(messages.stream().map(MessageDTO::entityToDTO).collect(Collectors.toList()), header, HttpStatus.OK);
    }

}
