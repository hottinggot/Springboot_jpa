package jpaboard.board.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="board")
@Data
public class Board {
    @Id
    @GeneratedValue
    private Long seq;
    private String title;
    private String writer;
    private String content;
    private Date createDate;
    private Long cnt;

    @Override
    public String toString(){
        return "Board [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", createDate=" + createDate + ", cnt=" + cnt + "]";
    }
}
