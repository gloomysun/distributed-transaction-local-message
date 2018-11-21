package com.ly.user.service.impl;

import com.ly.common.utils.IdWorker;
import com.ly.common.utils.JsonUtil;
import com.ly.user.dao.UserRepository;
import com.ly.user.entity.Message;
import com.ly.user.entity.User;
import com.ly.user.service.MessageService;
import com.ly.user.service.UserService;
import com.ly.user.vo.MessagePayload;
import com.ly.user.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserRepository userRepository;
    @Override
    public void save(UserVo userVo) {
        //1.保存用户
        User user = new User();
        BeanUtils.copyProperties(userVo,user);
        user.setUserid(idWorker.nextId());
        userRepository.save(user);
        //2.生成消息内容
        Long messageid = idWorker.nextId();
        MessagePayload payload = new MessagePayload();
        payload.setMessageid(messageid);
        //3.保存本地消息
        messageService.saveMessage(JsonUtil.object2Json(payload),messageid);
        //4.发送消息

    }
}
