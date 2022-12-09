package com.jg.rollingpage.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MessageDTO {

    private Integer messageId;
    private Integer userId;
    private String userNickname;
    private Integer categoryId;
    private String messageContents;
    private String senderNickname;
    private LocalDateTime readAt;
    private String messageReply;
    private String deleteAt;
    private LocalDateTime createAt;
    private Date openAt;

    @Builder
    public MessageDTO(Integer messageId, Integer userId, Integer categoryId, String messageContents, String senderNickname, LocalDateTime readAt, String messageReply, String deleteAt, LocalDateTime createAt, String userNickname, Date openAt) {
        this.messageId = messageId;
        this.userId = userId;
        this.categoryId = categoryId;
        this.messageContents = messageContents;
        this.senderNickname = senderNickname;
        this.readAt = readAt;
        this.messageReply = messageReply;
        this.deleteAt = deleteAt;
        this.createAt = createAt;
        this.userNickname = userNickname;
        this.openAt = openAt;
    }

    public static MessageDTO entityToDTO(Message message){
        return MessageDTO.builder()
                .messageId(message.getMessageId())
                .categoryId(message.getCategory().getCategoryId())
                .userId(message.getUser().getUserId())
                .userNickname(message.getUser().getUserNickname())
                .messageContents(message.getMessageContents())
                .senderNickname(message.getSenderNickname())
                .readAt(message.getReadAt())
                .messageReply(message.getMessageReply())
                .createAt(message.getCreateAt())
                .openAt(message.getCategory().getOpenAt())
                .build();
    }
}
