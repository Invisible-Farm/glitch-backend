package com.loeaf.ivfm.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.loeaf.siginin.model.Account;
import com.loeaf.siginin.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "Recommand")
@AllArgsConstructor
@NoArgsConstructor
public class Recommand {
    @Id
    private String id;

    @Column
    String valueCreated;

    @Column
    String myResponse;

    @Column(columnDefinition = "TEXT", length = 65535)
    String stroy;

    // 추천 하는 사람
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "from_user_id")
    @JsonBackReference
    private User fromUser;

    // 추천 받는 사람
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "to_user_id")
    @JsonBackReference
    private User toUser;

    // 추천 인센스
    @OneToMany(mappedBy = "recommand", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<RecommandIncense> recommandIncenses;

}