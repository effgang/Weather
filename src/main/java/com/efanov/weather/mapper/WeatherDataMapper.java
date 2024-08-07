package com.efanov.weather.mapper;

import com.efanov.weather.model.dto.WeatherDTO;
import com.efanov.weather.model.entity.WeatherData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WeatherDataMapper {

    WeatherDataMapper INSTANCE = Mappers.getMapper(WeatherDataMapper.class);

    WeatherDTO mapToDTO(WeatherData weatherData);


}
