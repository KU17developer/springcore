package com.bs.spring.demo.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Demo {

    @NotEmpty
    private String devName;

    @Min(value=14)
    private int devAge;

    private String devGender;
    private String[] devLang;
    private Address address;

    private Date birthday;


    private String devEmail;

}
