package jpaboard.board;

import jpaboard.board.domain.Board;
import jpaboard.board.domain.Member;
import jpaboard.board.domain.Role;
import jpaboard.board.persistence.BoardRepository;
import jpaboard.board.persistence.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataInitializeTest {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BoardRepository boardRepository;
/*
    @Test
    public void testDataInsert(){
        Member member1 = new Member();
        member1.setId("member1");
        member1.setName("둘리");
        member1.setPassword("member111");
        member1.setRole("ROLE_USER");

        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setId("member2");
        member2.setName("도우너");
        member2.setPassword("member222");
        member2.setRole("ROLE_ADMIN");

        memberRepository.save(member2);

        for(int i=1; i<=3; i++){
            Board board = new Board();
            board.setWriter("둘리");
            board.setTitle("둘리가 등록한 게시글 " + i);
            board.setContent("내용 " + i);
            boardRepository.save(board);
        }

        for(int i=1; i<=3; i++){
            Board board = new Board();
            board.setWriter("도우너");
            board.setTitle("도우너가 등록한 게시글 " + i);
            board.setContent("내용 " + i);
            boardRepository.save(board);
        }
    }*/
}
