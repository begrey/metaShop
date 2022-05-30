package com.merit.metaShop.board.domain;

import com.merit.metaShop.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="qna")
public class Qna {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @Lob
    private String content;

    @Lob
    private String reply;

    @Column(name="reg_date")
    private LocalDateTime registerDate;

    @Column(name="modify_date")
    private LocalDateTime modifyDate;

    private boolean replied;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
