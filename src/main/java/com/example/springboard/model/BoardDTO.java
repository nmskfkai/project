package com.example.springboard.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Date;

@Data
@Alias("boardDTO")
public class BoardDTO {
    private int id;
    private String content;
    private String title;
    private Date entryDate;
    private Date modifyDate;
    private Date WriteDate;
    private int writerId;
    private String nickname;
}
