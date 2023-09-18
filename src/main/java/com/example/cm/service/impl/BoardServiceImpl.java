package com.example.cm.service.impl;

import com.example.cm.data.dto.BoardDTO;
import com.example.cm.data.entity.Board;
import com.example.cm.data.repository.BoardRepository;
import com.example.cm.service.BoardService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public List<Board> getBoard() {
        return boardRepository.findAll();
    }

    @Override
    public Optional<Board> getBoardById(Long id) {
        return boardRepository.findById(id);
    }

    @Override
    public void saveBoard(BoardDTO boardDTO) {

//        boardDTO.setCreatedAt(LocalDateTime.now());
        Board board = boardDTO.toEntity();

        boardRepository.save(board);
    }

    @Override
    public void updateBoard(BoardDTO boardDTO) {

        boardDTO.setUpdatedAt(LocalDateTime.now());
        Board board = boardDTO.toEntity();

        boardRepository.save(board);
    }

    @Override
    public void deleteBoard(Long id) {
        //TODO: 삭제 시 deleteYn = true로 만들고 배치작업? (ex) 30일 뒤 deleteYn = true인 데이터 삭제
//        Optional<Board> selectedBoard = boardRepository.findById(id);
        boardRepository.deleteById(id);
    }
}
