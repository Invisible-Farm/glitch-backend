package com.loeaf.ivfm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.loeaf.siginin.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "CommunityUser")
@AllArgsConstructor
@NoArgsConstructor
public class CommunityUser {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    @JsonBackReference
    private Community community;
}