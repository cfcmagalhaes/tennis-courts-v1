package com.tenniscourts.tenniscourts;

import com.tenniscourts.exceptions.EntityNotFoundException;
import com.tenniscourts.schedules.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TennisCourtService
{

    private final TennisCourtRepository tennisCourtRepository;

    private final ScheduleService scheduleService;

    private final TennisCourtMapper tennisCourtMapper;

    public List<TennisCourtDTO> findAll( )
    {
	return tennisCourtMapper.map( tennisCourtRepository.findAll( ) );
    }

    public TennisCourtDTO findById( Long id )
    {
	return tennisCourtRepository.findById( id ).map( tennisCourtMapper::map ).orElseThrow( ( ) -> {
	    throw new EntityNotFoundException( "Tennis Court not found." );
	} );
    }

    public TennisCourtDTO add( TennisCourtDTO tennisCourt )
    {
	return tennisCourtMapper.map( tennisCourtRepository.saveAndFlush( tennisCourtMapper.map( tennisCourt ) ) );
    }

    public TennisCourtDTO update( TennisCourtDTO tennisCourtDTO )
    {
	findById( tennisCourtDTO.getId( ) );
        TennisCourt tennisCourt = tennisCourtRepository.save( tennisCourtMapper.map( tennisCourtDTO ) );

	return tennisCourtMapper.map( tennisCourt );
    }

    public void delete( Long tennisCourtId )
    {
        findById( tennisCourtId );
        tennisCourtRepository.deleteById( tennisCourtId );
    }

    public TennisCourtDTO findByIdWithSchedules( Long tennisCourtId )
    {
	TennisCourtDTO tennisCourtDTO = findById( tennisCourtId );
	tennisCourtDTO.setTennisCourtSchedules( scheduleService.findSchedulesByTennisCourtId( tennisCourtId ) );
	return tennisCourtDTO;
    }
}
