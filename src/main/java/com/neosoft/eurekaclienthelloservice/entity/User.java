package com.neosoft.eurekaclienthelloservice.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/*@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor*/
@Data
@Entity
@Table(name = "user_tab")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @Column(name = "ID")
    private  String userId;

    @Column(name = "NAME")
    private  String name;
    @Column(name = "EMAIL")
    private  String email;

    @Column(name = "ABOUT")
    private  String about;

    @Transient
    private List<Rating>  ratings = new ArrayList<>();

   /* private  Long id;

    private  String first_name;
    private  String last_name;
    private  String father_name;
    private  String mother_name;*/


}
