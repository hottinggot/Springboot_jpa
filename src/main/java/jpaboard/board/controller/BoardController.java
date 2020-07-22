package jpaboard.board.controller;


import jpaboard.board.domain.Board;
import jpaboard.board.domain.Member;
import jpaboard.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SessionAttributes("member")
@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping("/hello")
    public void printHello(Model model){
        model.addAttribute("greeting","Hello 타임리프^^");
    }

    @ModelAttribute("member")
    public Member setMember(){
        return new Member();
    }

    @RequestMapping("/getBoardList")
    public String getBoardList(@ModelAttribute("member") Member member, Model model) {
        if(member.getId() == null){
            return "redirect:login";
        }
        List<Board> boardList = boardService.getBoardList();

        model.addAttribute("boardList", boardList);
        return "getBoardList";
    }

    @GetMapping("/insertBoard")
    public String insertBoardView(@ModelAttribute("member") Member member){
        if(member.getId() == null){
            return "redirect:login";
        }
        return "insertBoard";
    }

    @PostMapping("/insertBoard")
    public String insertBoard(Board board, @ModelAttribute("member") Member member){
        if(member.getId() == null){
            return "redirect:login";
        }
        boardService.insertBoard(board);
        return "redirect:getBoardList";
    }

    @GetMapping("/getBoard")
    public String getBoard(Board board, Model model, @ModelAttribute("member") Member member){
        if(member.getId() == null){
            return "redirect:login";
        }
        model.addAttribute("board",boardService.getBoard(board));
        return "getBoard";
    }

    @PostMapping("/updateBoard")
    public String updateBoard(Board board, @ModelAttribute("member") Member member){
        if(member.getId() == null){
            return "redirect:login";
        }
        boardService.updateBoard(board);
        return "forward:getBoardList";
    }

    @GetMapping("/deleteBoard")
    public String deleteBoard(Board board, @ModelAttribute("member") Member member){
        if(member.getId() == null){
            return "redirect:login";
        }
        boardService.deleteBoard(board);
        return "forward:getBoardList";
    }

}
