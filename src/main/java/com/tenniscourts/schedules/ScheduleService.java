package com.tenniscourts.schedules;

import com.tenniscourts.exceptions.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ScheduleService
{

    private final ScheduleRepository scheduleRepository;

    private final ScheduleMapper scheduleMapper;

    public ScheduleDTO addSchedule( Long tennisCourtId, CreateScheduleRequestDTO createScheduleRequestDTO )
    {
	//TODO: implement addSchedule
	return null;
    }

    public ScheduleDTO findById( Long scheduleId )
    {
	return scheduleRepository.findById( scheduleId ).map( scheduleMapper::map )
			.<EntityNotFoundException>orElseThrow( ( ) -> {
			    throw new EntityNotFoundException(
					    "Schedule having id = " + scheduleId + " was not found" );
			} );
    }

    public List<ScheduleDTO> findSchedulesByDates( LocalDateTime startDate, LocalDateTime endDate )
    {
	//TODO: implement
	return null;
    }

    public List<ScheduleDTO> findSchedulesByTennisCourtId( Long tennisCourtId )
    {
	return scheduleMapper.map( scheduleRepository.findByTennisCourt_IdOrderByStartDateTime( tennisCourtId ) );
    }
}
