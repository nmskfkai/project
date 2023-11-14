package com.example.springboard.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@Alias("userDTO")
public class UserDTO {
    private int id;
    private String email;
    private String nickname;
    private String password;
    private String username;
    private Date entryDate;
    private Date modifyDate;
}
