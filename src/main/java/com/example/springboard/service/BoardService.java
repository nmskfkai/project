package com.example.springboard.service;

import com.example.springboard.model.BoardDTO;
import com.example.springboard.model.CommentDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BoardService {
    private SqlSession sqlSession;
    private final String NAMESPACE = "com.example.mapper.BoardMapper";



    @Autowired
    public BoardService(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    public List<BoardDTO> selectAll(){
        return sqlSession.selectList(NAMESPACE+".selectAll");
    }

    public BoardDTO selectOne(int id){
        return sqlSession.selectOne(NAMESPACE+".selectOne", id);
    }

    public void insert(BoardDTO boardDTO){
        sqlSession.insert(NAMESPACE+".insert", boardDTO);
    }

    public void update(BoardDTO boardDTO){
        sqlSession.update(NAMESPACE+".update", boardDTO);
    }

    public void delete(int id){
        sqlSession.delete(NAMESPACE+".delete", id);
    }

    public void addComment(CommentDTO comment) {
        sqlSession.insert(NAMESPACE + ".addComment", comment);
    }

    public List<CommentDTO> getCommentsByBoardId(int boardId) {
        return sqlSession.selectList(NAMESPACE + ".getCommentsByBoardId", boardId);
    }
    public CommentDTO getCommentById(int commentId) {
        return sqlSession.selectOne(NAMESPACE + ".getCommentById", commentId);
    }



}
