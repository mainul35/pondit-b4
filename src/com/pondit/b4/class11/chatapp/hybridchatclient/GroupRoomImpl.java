package com.pondit.b4.class11.chatapp.hybridchatclient;

import com.pondit.b4.class11.chatapp.ChatMessage;
import com.pondit.b4.class11.chatapp.GroupRoom;
import com.pondit.b4.class11.chatapp.Participant;

import java.util.List;

public class GroupRoomImpl implements GroupRoom {

    private Participant admin;
    private List<Participant> participants;
    private String name;
    private List<ChatMessage> messages;

    public GroupRoomImpl(Participant admin, String name) {
        this.admin = admin;
        this.name = name;
    }

    @Override
    public void addParticipant(Participant participant) {

    }

    @Override
    public void sendMessage(Participant sender, List<Participant> receivers, String message) {

    }

    @Override
    public Participant getAdmin() {
        return admin;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<ChatMessage> fetchMessages(String roomId) {
        return messages;
    }

    public void addMessage(ChatMessage chatMessage) {

    }

    public void setAdmin(Participant admin) {
        this.admin = admin;
    }
}
