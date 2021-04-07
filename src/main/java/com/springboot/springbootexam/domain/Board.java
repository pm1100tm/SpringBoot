package com.springboot.springbootexam.domain;

import lombok.Data;

@Data
public class Board {
    private int boardSequence;
    private BoardType boardType;
    private String title;
    private String contents;
    private String createdAt;
    private String updatedAt;
    private boolean isDeleted;
    
    public Board () {
    }
    
    public Board (BoardType boardType, String title, String contents) {
        this.boardType = boardType;
        this.title = title;
        this.contents = contents;
    }
}
