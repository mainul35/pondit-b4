package com.pondit.b4.class11.chatapp;

public interface ChatMessage {
    Participant sender();
    String message();
    String roomId();
}
