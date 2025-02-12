package com.bs.spring.demo.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Demo {

    @NotEmpty
    private String devName;

    @Min(value=14)  // 최소 나이
    private int devAge;

    private String devGender;
    private String[] devLang;
    private Address address;

    @Past   // 생일이니깐 당연히 과거여야되잖아!  (이전!)
    private Date birthday;

    @Email
    private String devEmail;

}
