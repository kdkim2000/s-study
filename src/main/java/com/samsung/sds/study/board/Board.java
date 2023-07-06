package com.samsung.sds.study.board;

import javax.persistence.*;

@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    private String title;
    @Column (length = 2000)
    private String contents;
}
