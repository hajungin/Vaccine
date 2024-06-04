package com.example.hospital.service;

import com.example.hospital.dto.VaccresvDTO;
import com.example.hospital.mapper.MainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {
    @Autowired
    MainMapper mainMapper;
    public void save(VaccresvDTO vaccresvDTO) {
        mainMapper.save(vaccresvDTO);
    }

    public List<VaccresvDTO> findAll(VaccresvDTO vaccresvDTO) {
        return mainMapper.findAll(vaccresvDTO);
    }

    public Long getNextVal() {
        return mainMapper.next();
    }

    public Long findMaxResvNo() {
        return mainMapper.max();
    }

    public VaccresvDTO findOne(Long id,String jumin) {
        if (id != null) {
            return mainMapper.findOne(id);
        } else  {
            return mainMapper.findjumin(jumin);
        }
    }


    public List<VaccresvDTO> result() {
        return mainMapper.result();
    }

    public Long sum() {
        return mainMapper.sum();
    }
}
