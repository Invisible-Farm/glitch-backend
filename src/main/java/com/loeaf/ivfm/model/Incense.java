package com.loeaf.ivfm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "Incense")
@AllArgsConstructor
@NoArgsConstructor
public class Incense {
    @Id
    private String id;
    @Column
    private String name;
    @Column
    private String korName;
}