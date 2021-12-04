package com.pondit.b4.class11.chatapp;

import java.util.List;

public interface GroupRoom extends Room {
    void addParticipant(Participant participant);
    void sendMessage(Participant sender, List<Participant> receivers, String message);
    Participant getAdmin();
}
