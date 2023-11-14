package com.example.springboard.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Date;

@Data
@Alias("commentDTO")
public class CommentDTO {
    private int id;
    private String content;
    private Date entryDate;
    private Date modifyDate;
    private int writerId;
    private int boardId;
    private String nickname; // 작성자의 닉네임 등 추가 필드

    @Override
    public String toString() {
        return "CommentDTO{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", entryDate=" + entryDate +
                ", modifyDate=" + modifyDate +
                ", writerId=" + writerId +
                ", boardId=" + boardId +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
