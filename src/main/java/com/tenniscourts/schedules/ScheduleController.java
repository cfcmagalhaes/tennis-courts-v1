package com.tenniscourts.schedules;

import com.tenniscourts.config.BaseRestController;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping( "/schedules" )
public class ScheduleController extends BaseRestController
{

    private final ScheduleService scheduleService;

    @PostMapping
    @ApiOperation( value = "Add a new slot" )
    public ResponseEntity<Void> addScheduleTennisCourt( CreateScheduleRequestDTO createScheduleRequestDTO )
    {
	return ResponseEntity.created( locationByEntity(
			scheduleService.addSchedule( createScheduleRequestDTO.getTennisCourtId( ),
					createScheduleRequestDTO ).getId( ) ) ).build( );
    }

    @PostMapping( "/filters" )
    @ApiOperation( value = "Find all the schedules between 2 given dates" )
    public ResponseEntity<List<ScheduleDTO>> findSchedulesByDates(
		    @RequestBody ScheduleFilterRequestDTO scheduleFilterRequestDTO )
    {
	return ResponseEntity.ok( scheduleService.findSchedulesByDates( scheduleFilterRequestDTO.getStartDateTime( ),
			scheduleFilterRequestDTO.getEndDateTime( ) ) );
    }

    @GetMapping( "/{scheduleId}" )
    @ApiOperation( value = "Find a schedule by id" )
    public ResponseEntity<ScheduleDTO> findScheduleById( @PathVariable Long scheduleId )
    {
	return ResponseEntity.ok( scheduleService.findById( scheduleId ) );
    }
}
