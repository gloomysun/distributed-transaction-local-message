package com.ly.user.service.impl;

import com.ly.common.enums.MessageDeadStatusEnum;
import com.ly.common.enums.MessageSendStatusEnum;
import com.ly.common.utils.IdWorker;
import com.ly.user.dao.MessageRepository;
import com.ly.user.entity.Message;
import com.ly.user.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private IdWorker idWorker;
    @Autowired
    private MessageRepository messageRepository;


    @Override
    public void saveMessage(String payload, Long messageid) {
        Message message = new Message();
        message.setId(messageid);
        message.setStatus(MessageSendStatusEnum.SENDING.name());
        message.setAlreadyDead(MessageDeadStatusEnum.NODEAD.name());
        message.setCreatetime(new Date());
        message.setEdittime(new Date());
        message.setPayload(payload);
        messageRepository.save(message);
    }
}
