package jpaboard.board.persistence;

import jpaboard.board.domain.Board;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {
    List<Board> findByTitle(String searchKeyword);
}
