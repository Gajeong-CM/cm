package com.example.cm.data.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "board")
@Getter
@Setter
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PK
    @Column(nullable = true)
    private String title; // 제목
    @Column(nullable = true)
    private String content; // 내용
    @Column(nullable = true)
    private String writer; // 작성자
    @Column(nullable = true)
    private int viewCnt; // 조회 수
    @Column(nullable = true)
    private char deleteYn; // 삭제 여부

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
