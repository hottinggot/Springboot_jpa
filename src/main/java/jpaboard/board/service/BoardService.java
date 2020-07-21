package jpaboard.board.service;

import jpaboard.board.domain.Board;

import java.util.List;

public interface BoardService {
    List<Board> getBoardList();
    void insertBoard(Board board);
    Board getBoard(Board board);
    void updateBoard(Board board);
    void deleteBoard (Board board);

}
