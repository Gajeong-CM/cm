package com.example.cm.service.impl;

import com.example.cm.data.dto.ScheduleDTO;
import com.example.cm.data.entity.Schedule;
import com.example.cm.data.repository.ScheduleRepository;
import com.example.cm.service.ScheduleService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public List<Schedule> getScheduleList() {
        return scheduleRepository.findAll();
    }

    @Override
//    @Transactional
    public void saveSchedule(ScheduleDTO scheduleDTO) {

//        scheduleDTO.setCreatedAt(LocalDateTime.now()); // 생성일시 적용
        Schedule schedule = scheduleDTO.toEntity();

        scheduleRepository.save(schedule);
    }

    @Override
//    @Transactional
    public void updateSchedule(ScheduleDTO scheduleDTO) {

        Schedule schedule = scheduleDTO.toEntity();

        System.out.println("수정 : " + schedule.toString());

        scheduleRepository.save(schedule);
    }

    @Override
//    @Transactional
    public void deleteSchedule(Long id) {

        Optional<Schedule> selectedSchdule = scheduleRepository.findById(id);

        if(selectedSchdule.isPresent()) {
            scheduleRepository.deleteById(id);
        } else {
            System.out.println("존재하지 않는 일정입니다.");
        }
    }
}