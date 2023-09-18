package com.example.cm.data.dto;

import com.example.cm.data.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {

    private String title; // 제목
    private String content; // 내용
    private String writer; // 작성자
    private Integer viewCnt; // 조회 수
    private Boolean deleteYn; // 삭제 여부

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .viewCnt(viewCnt)
                .build();
    }}
