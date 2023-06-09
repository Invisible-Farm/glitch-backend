package com.loeaf.ivfm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.loeaf.siginin.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "Community")
@AllArgsConstructor
@NoArgsConstructor
public class Community {
    @Id
    private String id;

    @Column
    String name;

    @OneToMany(mappedBy = "community", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommunityUser> communityUsers;

    public Community(String id, String name){
        this.id = id;
        this.name = name;
    }
}