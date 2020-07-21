package jpaboard.board.service;

import jpaboard.board.domain.Board;
import jpaboard.board.persistence.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardRepository boardRepo;

    public List<Board> getBoardList(){
        return (List<Board>) boardRepo.findAll();
    }

    public void insertBoard(Board board){
        boardRepo.save(board);
    }

    public Board getBoard(Board board){
        return boardRepo.findById(board.getSeq()).get();
    }

    public void updateBoard(Board board){
        Board findBoard = boardRepo.findById(board.getSeq()).get();
        findBoard.setTitle(board.getTitle());
        findBoard.setContent(board.getContent());
        boardRepo.save(findBoard);
    }

    public void deleteBoard (Board board){
        boardRepo.deleteById(board.getSeq());
    }
}
