package jpaboard.board;

import jpaboard.board.domain.Board;
import jpaboard.board.persistence.BoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardApplicationTests {

    @Autowired
    private BoardRepository boardRepo;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testInsertBoard() throws Exception{
        Board board = new Board();
        board.setTitle("첫 게시글");
        board.setWriter("테스터");
        board.setContent("잘 등록 되나요?");
        board.setCreateDate(new Date());
        board.setCnt(0L);

        boardRepo.save(board);
    }

    @Test
    public void testGetBoard(){
        Board board = boardRepo.findById(1L).get();
        System.out.println(board.toString());
    }

    @Test
    public void testUpdateBoard(){
        Board board = boardRepo.findById(1L).get();
        board.setTitle("제목 수정함");
        boardRepo.save(board);
    }

}
