package jpaboard.board.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Member {
    @Id
    @Column(name="member_id")
    private String id;
    private String password;
    private String name;
    private String role;
/*
    @OneToMany(mappedBy = "member", fetch= FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Board> boardList = new ArrayList<Board>();

 */
}
