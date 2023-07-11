package com.samsung.sds.study.board;

import com.samsung.sds.study.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardRepository boardRepository;

    @GetMapping
    public String index() {
        return "redirect:/board/list";
    }
    @GetMapping("/list")
    public String getBoards(Model model) {
        List<Board> boards = boardRepository.findAll();
        model.addAttribute("boards", boards);
        return "boardList.html";
    }
    @GetMapping("/form")
    public String getBoard(Model model,
                           @RequestParam(required = false) Long id) {
        Board board;
        if(id == null){
            board = new Board();
        }else{
            board = boardRepository.findById(id).orElse(null);
        }
        model.addAttribute("board", board);
        return "boardForm.html";
    }
    @PostMapping("/form")
    public String boardSubmit(@ModelAttribute Board board, Model model) {
        boardRepository.save(board);
        return "redirect:/board/list";
    }
}