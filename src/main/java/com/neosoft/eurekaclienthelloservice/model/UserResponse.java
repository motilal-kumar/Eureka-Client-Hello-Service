package com.neosoft.eurekaclienthelloservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UserResponse {

    private Long id;
    private String first_name;
    private String last_name;
    private String father_name;
    private String mother_name;


}

