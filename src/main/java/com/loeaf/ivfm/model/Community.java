package com.loeaf.ivfm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "Community")
@AllArgsConstructor
@NoArgsConstructor
public class Community {
    @Id
    private String id;

    @Column
    String name;

}