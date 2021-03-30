package com.springboot.springbootexam.controller;

import com.springboot.springbootexam.domain.Board;
import com.springboot.springbootexam.service.BoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** 게시판 컨트롤러 
 * @author swd
 * @created Date 2021-03-31
 * @updated Date -
 * */
@RestController
@RequestMapping("/board")
@Api(tags = "게시판 API")
public class BoardController {
    
    @Autowired
    private BoardService boardService;
    
    /**
     * 게시판 목록 취득
     * @param -
     * @return List<Board>
     */
    @GetMapping("/list")
    @ApiOperation(value = "게시판 목록 취득", notes = "페이지 번호에 해당하는 게시판 글 목록을 취득합니다.")
    public List<Board> getList () {
        return boardService.getList();
    }

    /**
     * 게시판 글 취득
     * @param boardSequence
     * @return Board
     */
    @GetMapping("/{boardSequence}")
    @ApiOperation(value = "게시판 글 상세 조회", notes = "해당 게시글 내용의 상세 정보를 조회합니다.")
    @ApiImplicitParams({@ApiImplicitParam(name = "boardSequence", value = "게시판 글 번호", example = "1")})
    public Board get (@PathVariable int boardSequence) {
        return boardService.get(boardSequence);
    }
    
    /**
     * 게시판 글 생성
     * @param board
     * @return -
     */
    @PostMapping("")
    @ApiOperation(value = "게시판 글 생성", notes = "게시판 글을 생성합니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "게시판 글 제목", example = "게시판 제목입니다."),
            @ApiImplicitParam(name = "contents", value = "게시판 글 내용", example = "게시판 내용입니다.")
    })
    public void save (Board board) {
        boardService.save(board);
    }
    
    /**
     * 게시판 글 수정
     * @param board
     * @return -
     */
    @GetMapping("/update")
    @ApiOperation(value = "게시판 글 수정", notes = "게시판 글 수정")
    @ApiImplicitParams({@ApiImplicitParam(name = "board", value = "게시판 글 컨텐츠")})
    public void update (Board board) {
        boardService.update(board);
    }

    /**
     * 게시판 글 삭제
     * @param boardSequence
     * @return -
     */
    @GetMapping("/delete/{boardSequence}")
    @ApiOperation(value = "게시판 글 삭제", notes = "게시판 글을 삭제합니다.")
    @ApiImplicitParams({@ApiImplicitParam(name = "boardSequence", value = "게시판 글 번호", example = "1")})
    public void delete (@PathVariable int boardSequence) {
        boardService.delete(boardSequence);
    }
}
