package com.nazarvladyka.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class HomeWorld {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    private String name;
    private String url;
}
