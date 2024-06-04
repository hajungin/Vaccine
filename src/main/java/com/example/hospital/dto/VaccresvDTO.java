package com.example.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class VaccresvDTO {
    private Long resv_no;
    private String jumin;
    private String hosp_code;
    private LocalDate resv_date;
    private LocalTime resv_time;
    private String v_code;

    private String name;
    private String host_name;
    private String host_addr;
}
