package com.springboot.springbootexam.service;

import ch.qos.logback.classic.Logger;
import com.springboot.springbootexam.domain.Board;
import com.springboot.springbootexam.repository.BoardRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 게시판 서비스 
 * @author swd
 * @created Date 2021-03-31
 * @updated Date -
 * */
@Service
public class BoardService {
    
    @Autowired
    private BoardRepository boardRepository;
    
    /** 게시판 목록 취득 
     * @author swd
     * @param -
     * @return List<Board>
     * */
    public List<Board> getList () {
        return boardRepository.getList();
    }

    /** 게시판 상세 정보 취득 
     * @author swd
     * @param boardSequence
     * @return Board
     * */
    public Board get (int boardSequence) {
        return boardRepository.get(boardSequence);
    }
    
    /** 게시판 글 생성
     * @author swd
     * @param board
     * @return -
     * */
    public int save (Board board) {
        Board getBoard = boardRepository.get(board.getBoardSequence());
        if (getBoard == null) {
            boardRepository.save(board);
            return 1;
        }
        return 0;
    }
    
    /** 게시판 글 수정 
     * @author swd
     * @param board
     * @return -
     * */
    public int update (Board board) {
        Board getBoard = boardRepository.get(board.getBoardSequence());
        if (getBoard != null) {
            boardRepository.update(board);
            return 1;
        } 
        return 0;
    }
    
    /** 게시판 글 삭제
     * @author swd
     * @param boardSequence
     * @return -
     * */
    public boolean delete (int boardSequence) {
        Board getBoard = boardRepository.get(boardSequence);
        if (getBoard == null) {
            return false;
        }
        boardRepository.delete(boardSequence);
        return true;
    }
    
    public boolean saveList1(List<Board> boardList) {
        System.out.println("==================Service:: saveList1");
        for (Board board : boardList) {
            boardRepository.save(board);
        }
        return true;
    }
    
    public void saveList2(List<Board> boardList) {
        System.out.println("==================Service:: saveList2");
        Map<String, Object> boardMap = new HashMap<String, Object>();
        boardMap.put("boardList", boardList);
        boardRepository.saveList(boardMap);
    }
}
