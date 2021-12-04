package com.pondit.b4.class11.chatapp.hybridchatclient;

import com.pondit.b4.class11.chatapp.ChatMessage;
import com.pondit.b4.class11.chatapp.OneToOneRoom;
import com.pondit.b4.class11.chatapp.Participant;

import java.util.List;

public class OneToOneRoomImpl implements OneToOneRoom {
    @Override
    public void sendMessage(Participant sender, Participant receiver, String message) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public List<ChatMessage> fetchMessages(String roomId) {
        return null;
    }
}
