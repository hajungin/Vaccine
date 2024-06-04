package com.example.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HospitalDTO {
    private String host_code;
    private String host_name;
    private String host_tel;
    private String host_addr;
}
