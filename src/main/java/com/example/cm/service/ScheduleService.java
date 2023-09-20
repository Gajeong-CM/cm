package com.example.cm.service;

import com.example.cm.data.dto.ScheduleDTO;
import com.example.cm.data.entity.Schedule;

import java.util.List;

public interface ScheduleService {

    public List<Schedule> getScheduleList();

    public void saveSchedule(ScheduleDTO scheduleDTO);

    public void updateSchedule(ScheduleDTO scheduleDTO);

    public void deleteSchedule(Long id);

}
