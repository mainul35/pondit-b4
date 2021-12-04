package com.pondit.b4.class11.chatapp.hybridchatclient;

import com.pondit.b4.class11.chatapp.Participant;
import com.pondit.b4.class11.chatapp.Room;

import java.util.ArrayList;
import java.util.List;

public interface ChatRoom {

    List<Room> rooms = new ArrayList<>();

    static Room getRoom(String roomName) {
        for (Room room : rooms) {
            if (room.getName() != null && room.getName().equals(roomName)) {
                return room;
            }
        }
        return null;
    }

    default void createRoom(String roomName, boolean isGroup, Participant admin) {
        if (checkIfAlreadyExists(roomName)) {
            throw new RuntimeException("Sorry, Room name is already taken");
        }
        if (isGroup) {
            GroupRoomImpl room = new GroupRoomImpl(admin, roomName);
            rooms.add(room);
        }
    }


    private boolean checkIfAlreadyExists(String roomName) {
        for (Room room : rooms) {
            if (room.getName().equals(roomName)) {
                return true;
            }
        }
        return false;
    }
}
