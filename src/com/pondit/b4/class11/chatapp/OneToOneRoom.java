package com.pondit.b4.class11.chatapp;

public interface OneToOneRoom extends Room {
    void sendMessage(Participant sender, Participant receiver, String message);

}
