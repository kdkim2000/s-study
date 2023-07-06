package com.samsung.sds.study.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
public class BoardRestController {
    @Autowired
    BoardRepository boardRepository;

    @GetMapping("/list")
    public List<Board> getBorads(){
        List<Board> boards = boardRepository.findAll();
        return boards;
    }
    @PostMapping("/form")
    public Board boardSubmit(@RequestBody Board board){
        return boardRepository.save(board);
    }
}
