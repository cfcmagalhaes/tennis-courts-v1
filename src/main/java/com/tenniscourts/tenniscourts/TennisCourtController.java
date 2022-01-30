package com.tenniscourts.tenniscourts;

import com.tenniscourts.config.BaseRestController;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping( "tennis-courts" )
public class TennisCourtController extends BaseRestController
{

    private final TennisCourtService tennisCourtService;

    @GetMapping
    @ApiOperation( value = "List all Tennis Court" )
    public ResponseEntity<List<TennisCourtDTO>> findAllTennisCourts( )
    {
	return ResponseEntity.ok( tennisCourtService.findAll( ) );
    }

    @GetMapping( "/{tennisCourtId}" )
    @ApiOperation( value = "Find tennis court by id" )
    public ResponseEntity<TennisCourtDTO> findTennisCourtById( @PathVariable Long tennisCourtId )
    {
	return ResponseEntity.ok( tennisCourtService.findById( tennisCourtId ) );
    }

    @PostMapping
    @ApiOperation( value = "Add a tennis court" )
    public ResponseEntity<Void> addTennisCourt( @RequestBody TennisCourtDTO tennisCourtDTO )
    {
	return ResponseEntity.created( locationByEntity( tennisCourtService.add( tennisCourtDTO ).getId( ) ) ).build( );
    }

    @PutMapping
    @ApiOperation( value = "Update a tennis court" )
    public ResponseEntity<TennisCourtDTO> updateTennisCourt( @RequestBody TennisCourtDTO tennisCourtDTO )
    {
	return ResponseEntity.ok( tennisCourtService.update( tennisCourtDTO ) );
    }

    @DeleteMapping( "/{tennisCourtId}" )
    @ApiOperation( value = "Delete a tennis court" )
    public ResponseEntity<Void> deleteTennisCourt( @PathVariable Long tennisCourtId )
    {
	tennisCourtService.delete( tennisCourtId );
	return ResponseEntity.ok( ).build( );
    }

    @GetMapping( "/{tennisCourtId}/schedules" )
    @ApiOperation( value = "Find schedules for a tennis court" )
    public ResponseEntity<TennisCourtDTO> findTennisCourtWithSchedulesById( @PathVariable Long tennisCourtId )
    {
	return ResponseEntity.ok( tennisCourtService.findByIdWithSchedules( tennisCourtId ) );
    }
}