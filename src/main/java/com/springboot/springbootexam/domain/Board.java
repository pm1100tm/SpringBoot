package com.springboot.springbootexam.domain;

import lombok.Data;

@Data
public class Board {
    private int boardSequence;
    private String title;
    private String contents;
    private String createdAt;
    private String updatedAt;
    private boolean isDeleted;

    public Board () {
    }

    public Board (String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
