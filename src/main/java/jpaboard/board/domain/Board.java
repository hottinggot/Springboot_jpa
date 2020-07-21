package jpaboard.board.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="board")
@Data
public class Board {
    @Id
    @GeneratedValue
    private Long seq;
    private String title;

    @Column(updatable = false)
    private String writer;
    private String content;

    @Column(insertable = false, updatable = false, columnDefinition = "DATETIME DEFAULT NOW()")
    private Date createDate;

    @Column(insertable = false,updatable = false, columnDefinition = "int default 0")
    private Long cnt;
/*
    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;
*/
    @Override
    public String toString(){
        return "Board [seq=" + seq + ", title=" + title + ", content=" + content + ", createDate=" + createDate + ", cnt=" + cnt + "]";
    }
}
