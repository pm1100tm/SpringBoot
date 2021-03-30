package com.springboot.springbootexam.repository;

import com.springboot.springbootexam.domain.Board;
import org.springframework.stereotype.Repository;

import java.util.List;

/** 게시판 레포지토리 
 * @author swd
 * @created Date 2021-03-31
 * @updated Date -
 * */
@Repository
public interface BoardRepository {
    List<Board> getList();
    
    Board get(int boardSequence);
    
    void save(Board board);
    
    void update(Board board);
    
    boolean delete(int boardSequence);
}
