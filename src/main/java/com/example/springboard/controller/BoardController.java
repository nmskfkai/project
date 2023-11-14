package com.example.springboard.controller;

import com.example.springboard.model.BoardDTO;
import com.example.springboard.model.CommentDTO;
import com.example.springboard.model.UserDTO;
import com.example.springboard.service.BoardService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String showHome(){
        return "index";
    }

    @GetMapping("/board/showAll")
    public ModelAndView printAll(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("list", boardService.selectAll());
        mv.setViewName("board/showAll");
        return mv;
    }

    @GetMapping("/board/write")
    public String showWrite(){
        return "board/write";
    }

    @PostMapping("/board/write")
    public String write(HttpSession session, BoardDTO boardDTO){
        UserDTO logIn = (UserDTO) session.getAttribute("logIn");
        if (logIn != null) {
            boardDTO.setWriterId(logIn.getId());
            boardService.insert(boardDTO);
        }
        return "redirect:/board/showAll";
    }

    @PostMapping("/board/addComment/{id}")
    public String addComment(@PathVariable int id, HttpSession session, String commentContent) {
        UserDTO logIn = (UserDTO) session.getAttribute("logIn");
        if (logIn != null) {
            CommentDTO comment = new CommentDTO();
            comment.setBoardId(id);
            comment.setContent(commentContent);
            comment.setWriterId(logIn.getId());
            comment.setNickname(logIn.getNickname());
            boardService.addComment(comment);
        }
        return "redirect:/board/showOne/" + id;
    }

    @GetMapping("/board/showOne/{id}")
    public String showOne(@PathVariable int id, HttpSession session, Model model) {
        BoardDTO boardDTO = (BoardDTO) boardService.selectOne(id);
        model.addAttribute("board", boardDTO);
        model.addAttribute("logIn", (UserDTO) session.getAttribute("logIn"));
        List<CommentDTO> comments = boardService.getCommentsByBoardId(id);
        model.addAttribute("comments", comments);
        return "board/showOne";
    }

    // 수정 페이지로 이동
    @GetMapping("/board/update/{id}")
    public String showUpdateForm(@PathVariable int id, HttpSession session, Model model) {
        BoardDTO boardDTO = (BoardDTO) boardService.selectOne(id);
        // 게시글 작성자만 수정 가능하도록 보안 검사
        UserDTO logIn = (UserDTO) session.getAttribute("logIn");
        if (logIn != null && boardDTO != null && logIn.getId() == boardDTO.getWriterId()) {
            model.addAttribute("board", boardDTO);
            return "board/update"; // 수정 페이지로 이동
        } else {
            return "redirect:/board/showAll"; // 수정 권한이 없을 경우 목록 페이지로 리다이렉트
        }
    }

    // 수정 처리
    @PostMapping("/board/update")
    public String update(BoardDTO boardDTO) {
        boardService.update(boardDTO);
        return "redirect:/board/showAll"; // 수정 후 목록 페이지로 리다이렉트
    }

    // 삭제 처리
    @GetMapping("/board/delete/{id}")
    public String delete(@PathVariable int id, HttpSession session) {
        // 게시글 작성자만 삭제 가능하도록 보안 검사
        UserDTO logIn = (UserDTO) session.getAttribute("logIn");
        BoardDTO boardDTO = (BoardDTO) boardService.selectOne(id);
        if (logIn != null && boardDTO != null && logIn.getId() == boardDTO.getWriterId()) {
            boardService.delete(id); // 게시글 삭제
        }
        return "redirect:/board/showAll"; // 삭제 후 목록 페이지로 리다이렉트
    }
}
