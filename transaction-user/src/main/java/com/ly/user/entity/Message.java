package com.ly.user.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "tb_message")
@Data
public class Message {
    @Id
    private Long id;
    private Date createtime;
    private Date edittime;
    private String status; //消息状态
    private String payload; //消息内容
    private String alreadyDead;
}
