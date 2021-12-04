package com.pondit.b4.class11.chatapp;

import java.util.List;

public interface Room {
    String getName();
    List<ChatMessage> fetchMessages(String roomId);

}
