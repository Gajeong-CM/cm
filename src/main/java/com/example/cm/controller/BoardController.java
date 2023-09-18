package com.example.cm.controller;

import com.example.cm.data.dto.BoardDTO;
import com.example.cm.data.dto.ToastUiResponseDto;
import com.example.cm.data.entity.Board;
import com.example.cm.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }


    /**
     * [API] 게시글 리스트 조회
     * 해당 Response는 Toast UI Grid 에 맞는 Response 값으로 구성하여 반환한다.
     *
     * @author kyg
     * @version 1.0
     * @describe
     * @return
     *{
     *    "result": true,
     *    "data": {
     *        "contents": [],
     *        "pagination": {
     *            "page": 1,
     *            "totalCount": 100
     *        }
     *    }
     *}
     */
    @GetMapping("/board/data")
//    @Operation(summary = "게시글 리스트 조회", description = "게시글 리스트를 조회해오는 API")
    //TODO: 작은 작업 단위의 함수로 분리 가능?, reuslt에 성공(true)/실패(false) 여부 분기
    public ResponseEntity<ToastUiResponseDto> getBoardList() {
        List<Board> boardList = boardService.getBoard();


        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("contents", boardList);
        resultMap.put("paginagtion", "");


        ToastUiResponseDto toastUiResponseDto = ToastUiResponseDto.builder()
                        .result(true)
                        .data(resultMap)
                        .build();

        ResponseEntity<ToastUiResponseDto> res = new ResponseEntity<>(toastUiResponseDto, HttpStatus.OK);
        System.out.println(res);

        return res;
    }


    @PostMapping("/board/data")
    public void saveBoard(BoardDTO boardDTO) {
        System.out.println(boardDTO.toString());
        boardService.saveBoard(boardDTO);
    }

    @DeleteMapping("/board/data/{id}")
    public void deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
    }
}
