package com.tenniscourts.tenniscourts;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-29T21:08:59-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11.0.14 (Amazon.com Inc.)"
)
@Component
public class TennisCourtMapperImpl implements TennisCourtMapper {

    @Override
    public TennisCourtDTO map(TennisCourt source) {
        if ( source == null ) {
            return null;
        }

        TennisCourtDTO tennisCourtDTO = new TennisCourtDTO();

        tennisCourtDTO.setId( source.getId() );
        tennisCourtDTO.setName( source.getName() );

        return tennisCourtDTO;
    }

    @Override
    public TennisCourt map(TennisCourtDTO source) {
        if ( source == null ) {
            return null;
        }

        TennisCourt tennisCourt = new TennisCourt();

        tennisCourt.setId( source.getId() );
        tennisCourt.setName( source.getName() );

        return tennisCourt;
    }

    @Override
    public List<TennisCourtDTO> map(List<TennisCourt> source) {
        if ( source == null ) {
            return null;
        }

        List<TennisCourtDTO> list = new ArrayList<TennisCourtDTO>( source.size() );
        for ( TennisCourt tennisCourt : source ) {
            list.add( map( tennisCourt ) );
        }

        return list;
    }
}
