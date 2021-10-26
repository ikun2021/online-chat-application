package com.example.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatForm {
    private Integer messageid;
    private String username;
    private String messageText;
    private String messageType;
}
