package com.example.springboot.mapper;

import com.example.springboot.ApiResult.ZooRequest;
import com.example.springboot.ApiResult.ZooResponse;
import com.example.springboot.entity.Zoo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ZooConverter {

    ZooConverter INSTANCE = Mappers.getMapper(ZooConverter.class);

    Zoo requestToEntity(ZooRequest zooRequest);

    List<ZooResponse> entityToResponse(List<Zoo> zoos);

    ZooResponse entityToResponse(Zoo zoo);

}
