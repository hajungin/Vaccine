package com.example.hospital.mapper;

import com.example.hospital.dto.VaccresvDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MainMapper {
    void save(@Param("VaccresvDTO") VaccresvDTO vaccresvDTO);

    List<VaccresvDTO> findAll(@Param("VaccresvDTO") VaccresvDTO vaccresvDTO);

    Long next();

    Long max();

    VaccresvDTO findOne(@Param("id") Long id);
}
