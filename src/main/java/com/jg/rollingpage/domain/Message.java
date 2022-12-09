package com.jg.rollingpage.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Message {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "message_id")
    private Integer messageId;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = LAZY)
    private User user;
    
    @JoinColumn(name = "category_id")
    @ManyToOne(fetch = LAZY)
    private Category category;
    
    @Column(name = "message_contents")
    private String messageContents;
    
    @Column(name = "sender_nickname")
    private String senderNickname;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-dd", timezone = "Asia/Seoul")
    @Column(name = "read_at")
    private LocalDateTime readAt;
    
    @Column(name = "message_reply")
    private String messageReply;

    @Column(name = "delete_at")
    private String deleteAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Builder
    public Message(Integer messageId, Integer userId, Integer categoryId, String messageContents, String senderNickname, LocalDateTime readAt, String messageReply, String deleteAt, LocalDateTime createAt) {
        this.messageId = messageId;
        this.user = User.builder().userId(userId).build();
        this.category = Category.builder().categoryId(categoryId).build();
        this.messageContents = messageContents;
        this.senderNickname = senderNickname;
        this.readAt = readAt;
        this.messageReply = messageReply;
        this.deleteAt = deleteAt;
        this.createAt = createAt;
    }
}
