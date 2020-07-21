package jpaboard.board.persistence;

import jpaboard.board.domain.Board;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {
    List<Board> findByTitle(String searchKeyword);

    @Query(value="select seq,title,writer,createdate from board where title like '%'||?1||'%' "
    + "order by seq desc", nativeQuery = true)
    List<Object[]> queryAnnotationTest3(String searchKeyword);

    @Query("select b from Board b order by b.seq desc")
    List<Board> queryAnnotationTest4(Pageable paging);

}
