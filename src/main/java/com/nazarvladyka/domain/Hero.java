package com.nazarvladyka.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    private String name;
    private int height;
    private int mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    @Column(length = 500)
    private String[] films;
    @Column(length = 500)
    private String[] species;
    @Column(length = 500)
    private String[] vehicles;
    @Column(length = 500)
    private String[] starships;
    private String created;
    private String edited;
    private String url;
}