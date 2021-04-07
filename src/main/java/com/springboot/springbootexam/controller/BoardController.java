package com.springboot.springbootexam.controller;

import com.springboot.springbootexam.configuration.exception.BaseException;
import com.springboot.springbootexam.configuration.http.BaseResponse;
import com.springboot.springbootexam.configuration.http.BaseResponseCode;
import com.springboot.springbootexam.domain.Board;
import com.springboot.springbootexam.service.BoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    private final Logger logger = LoggerFactory.getLogger(this.getClass()); 
    
    @Autowired
    private BoardService boardService;
    
    /**
     * 게시판 목록 취득
     * @param -
     * @return List<Board>
     */
    @GetMapping("/list")
    @ApiOperation(value = "게시판 목록 취득", notes = "페이지 번호에 해당하는 게시판 글 목록을 취득합니다.")
    public BaseResponse<List<Board>> getList () {
        logger.info("getList");
        return new BaseResponse<List<Board>>(boardService.getList());
    }
    
    /**
     * 게시판 글 취득
     * @param boardSequence
     * @return Board
     */
    @GetMapping("/{boardSequence}")
    @ApiOperation(value = "게시판 글 상세 조회", notes = "해당 게시글 내용의 상세 정보를 조회합니다.")
    @ApiImplicitParams({@ApiImplicitParam(name = "boardSequence", value = "게시판 글 번호", example = "1")})
    public BaseResponse<Board> get (@PathVariable int boardSequence) {
        Board board = boardService.get(boardSequence);
        if (board == null) {
            throw new BaseException(BaseResponseCode.DATA_IS_NULL, new String[] {"게시물"});
        }
        
        return new BaseResponse<>(board);
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
    public BaseResponse<Integer> save (Board board) {
        // 제목 필수 체크
        if (!StringUtils.hasText((board.getTitle()))) {
            System.out.println("=================================");
            throw new BaseException(BaseResponseCode.VALIDATE_REQUIRED, new String[] {"title", "제목"});
        }
        // 내용 필수 체크
        if (!StringUtils.hasText(board.getContents())) {
            System.out.println("=================================");
            throw new BaseException(BaseResponseCode.VALIDATE_REQUIRED, new String[] {"contents", "내용물"});
        }
        
        return new BaseResponse<>(boardService.save(board));
    }
    
    /**
     * 게시판 글 수정
     * @param board
     * @return -
     */
    @PutMapping("/update")
    @ApiOperation(value = "게시판 글 수정", notes = "게시판 글 수정")
    @ApiImplicitParams({@ApiImplicitParam(name = "board", value = "게시판 글 컨텐츠")})
    public BaseResponse<Integer> update (Board board) {
        return new BaseResponse<Integer>(boardService.update(board));
    }
    
    /**
     * 게시판 글 삭제
     * @param boardSequence
     * @return -
     */
    @DeleteMapping("/delete/{boardSequence}")
    @ApiOperation(value = "게시판 글 삭제", notes = "게시판 글을 삭제합니다.")
    @ApiImplicitParams({@ApiImplicitParam(name = "boardSequence", value = "게시판 글 번호", example = "1")})
    public BaseResponse<Boolean> delete (@PathVariable int boardSequence) {
        return new BaseResponse<>(boardService.delete(boardSequence));
    }
    
    /**
     * 게시판 글 삭제
     * @param -
     * @return BaseResponse<Boolean>
     */
    @ApiOperation(value = "대용량 등록처리 1", notes = "게시물 10000건 등록 처리 1")
    @PostMapping("/saveList1")
    public BaseResponse<Boolean> saveListOne() {
        logger.info("====================================Controller:: saveList1");
        List<Board> boardList = new ArrayList<>();
        int count = 0;
        while (count < 10000) {
            String title = RandomStringUtils.randomAlphabetic(10);
            String contents = RandomStringUtils.randomAlphabetic(10);
            Board board = new Board(title, contents);
            boardList.add(board);
            if (count > 10000) {
                break;
            }
            count++;
        }
        
        long start = System.currentTimeMillis();
        boardService.saveList1(boardList);
        long end = System.currentTimeMillis();
        logger.info("실행 시간:: {}", (end - start) / 1000.0);
        
        return new BaseResponse<Boolean>(true);
    }
    
    /**
     * 게시판 글 삭제
     * @param -
     * @return BaseResponse<Boolean>
     */
    @ApiOperation(value = "대용량 등록처리 2", notes = "게시물 10000건 등록 처리 2")
    @PostMapping("/saveList2")
    public BaseResponse<Boolean> saveListTwo() {
        List<Board> boardList = new ArrayList<>();
        int count = 0;
        while (count < 10000) {
            String title = RandomStringUtils.randomAlphabetic(10);
            String contents = RandomStringUtils.randomAlphabetic(10);
            Board board = new Board(title, contents);
            boardList.add(board);
            if (count > 10000) {
                break;
            }
            count++;
        }
        
        long start = System.currentTimeMillis();
        boardService.saveList2(boardList);
        long end = System.currentTimeMillis();
        logger.info("실행 시간:: {}", (end - start) / 1000.0);
        
        return new BaseResponse<Boolean>(true);
    }
}
