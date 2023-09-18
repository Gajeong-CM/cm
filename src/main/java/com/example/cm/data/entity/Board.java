package com.example.cm.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "board")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE board SET delete_yn = true WHERE id = ?")
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
    private Integer viewCnt; // 조회 수
    @Column(nullable = true)
    private Boolean deleteYn; // 삭제 여부

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @PrePersist
    public void setDefaultValues() {
        this.viewCnt = 0;
        this.deleteYn = false;
        this.createdAt = LocalDateTime.now();
    }

}
