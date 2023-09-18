package com.example.cm.service;

import com.example.cm.data.dto.BoardDTO;
import com.example.cm.data.entity.Board;

import java.util.List;
import java.util.Optional;

public interface BoardService {
    List<Board> getBoard();

    Optional<Board> getBoardById(Long id);

    void saveBoard(BoardDTO boardDTO);

    void updateBoard(BoardDTO boardDTO);

    void deleteBoard(Long id);
}
