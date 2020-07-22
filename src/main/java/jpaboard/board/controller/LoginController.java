package jpaboard.board.controller;

import jpaboard.board.domain.Member;
import jpaboard.board.service.BoardService;
import jpaboard.board.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@SessionAttributes("member")
@Controller
public class LoginController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/login")
    public void loginView(){

    }

    @GetMapping("/loginSuccess")
    public void loginSuccess(){

    }

    @PostMapping("/login")
    public String login(Member member, Model model){
        Member findMember = memberService.getMember(member);

        if(findMember != null && findMember.getPassword().equals(member.getPassword())){
            model.addAttribute("member", findMember);
            return "forward:getBoardList";
        } else {
            return "redirect:login";
        }
    }

    @GetMapping("/logout")
    public String logout(SessionStatus status){
        status.setComplete();
        return "redirect:index.html";
    }
}
