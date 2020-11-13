package com.zk.msscbrewery.web.mappers;

import com.zk.msscbrewery.domain.Beer;
import com.zk.msscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);

}
