package com.ly.user.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "tb_user")
@Data
public class User {
    @Id
    private Long userid;
    private String username;
    private String password;
}
