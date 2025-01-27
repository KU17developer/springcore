package com.bs.spring.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Address {

    private String sido;
    private String gungu;
    private String dong;

}
