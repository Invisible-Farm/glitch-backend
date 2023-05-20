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
@Entity(name = "Incense")
@AllArgsConstructor
@NoArgsConstructor
public class Incense {
    public Incense(String id, String name){
        this.id = id;
        this.name = name;
    }
    @Id
    private String id;
    @Column
    private String name;
    @Column
    private String korName;
    @Column
    private String useYn;
    // 추천 인센스
    @OneToMany(mappedBy = "incense", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<RecommandIncense> recommandIncenses;

    @OneToMany(mappedBy = "incense", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FileInfo> fileInfos;
}