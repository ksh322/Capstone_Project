package com.involveininnovation.chat.controller;


import com.involveininnovation.chat.entity.MessageEntity;
import com.involveininnovation.chat.entity.RoomEntity;
import com.involveininnovation.chat.model.MessagePacket;
import com.involveininnovation.chat.service.MessageService;
import com.involveininnovation.chat.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class MessageController {
    private final RoomService roomService;
    private final MessageService messageService;


    @PostMapping("/api/room/{roomId}")
    public String createMessage(@RequestBody MessagePacket messagePacket){
        RoomEntity roomEntity = this.roomService.getRoom(messagePacket.getRoomId());
        //message 저장
        this.messageService.create(roomEntity,messagePacket.getSender() ,messagePacket.getContent());

        return "message communication success";
    }
}
