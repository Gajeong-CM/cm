package com.example.cm.controller;


import com.example.cm.data.dto.ScheduleDTO;
import com.example.cm.data.entity.Schedule;
import com.example.cm.service.ScheduleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/schedule/data")
    public String getSchedule() throws JsonProcessingException {

        List<Schedule> listAllSchedule = scheduleService.getScheduleList();

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String jsonStr = mapper.writeValueAsString(listAllSchedule);

        System.out.println("조회 : " + jsonStr);

        return jsonStr;
    }

    //TODO: 생성, 수정, 삭제 시 새로고침 없이 화면에 반영되게 해야함
    @PostMapping("/schedule/data")
    public void createSchedule(ScheduleDTO scheduleDTO) {
        System.out.println("생성 : " + scheduleDTO);

        scheduleService.saveSchedule(scheduleDTO);

    }

    @PutMapping("/schedule/data")
    public void updateSchedule(ScheduleDTO scheduleDTO) {

        scheduleService.updateSchedule(scheduleDTO);
    }

    @DeleteMapping("/schedule/data")
    public void deleteSchedule(Integer id) {
        scheduleService.deleteSchedule(id);

    }
}
