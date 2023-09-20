package com.example.cm.data.dto;

import com.example.cm.data.entity.Schedule;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ScheduleDTO {

    private Long id;

    private String groupId;

    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate start;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    // DTO -> Entity
    public Schedule toEntity() {
        return Schedule.builder()
                .id(id)
                .groupId(groupId)
                .title(title)
                .start(start)
                .end(end)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }


}
