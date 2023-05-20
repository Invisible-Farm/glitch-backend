package com.loeaf.ivfm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.loeaf.file.domain.FileInfo;
import com.loeaf.siginin.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "RecommandIncense")
@AllArgsConstructor
@NoArgsConstructor
public class RecommandIncense {
    @Id
    private String id;
    // 추천 받는 사람
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "recommand_id")
    @JsonBackReference
    private Recommand recommand;
    // 추천 받는 사람
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "incense_id")
    @JsonBackReference
    private Incense incense;

    @OneToMany(mappedBy = "recommandIncense", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<FileInfo> fileInfo;


}