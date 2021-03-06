package com.tenniscourts.guests;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-08T23:05:21-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11.0.13 (JetBrains s.r.o.)"
)
@Component
public class GuestMapperImpl implements GuestMapper {

    @Override
    public Guest map(GuestDTO source) {
        if ( source == null ) {
            return null;
        }

        Guest guest = new Guest();

        guest.setId( source.getId() );
        guest.setName( source.getName() );

        return guest;
    }

    @Override
    public GuestDTO map(Guest source) {
        if ( source == null ) {
            return null;
        }

        GuestDTO guestDTO = new GuestDTO();

        guestDTO.setId( source.getId() );
        guestDTO.setName( source.getName() );

        return guestDTO;
    }

    @Override
    public List<GuestDTO> map(List<Guest> source) {
        if ( source == null ) {
            return null;
        }

        List<GuestDTO> list = new ArrayList<GuestDTO>( source.size() );
        for ( Guest guest : source ) {
            list.add( map( guest ) );
        }

        return list;
    }
}
