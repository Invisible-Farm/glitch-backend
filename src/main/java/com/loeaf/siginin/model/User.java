package com.loeaf.siginin.model;

import com.loeaf.ivfm.model.CommunityUser;
import com.loeaf.ivfm.model.Recommand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "tn_user")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column
    private String id;
    @Column
    private String nickName;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommunityUser> communityUsers;
    // 내가 추천한 사람들 목록
    @OneToMany(mappedBy = "fromUser", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Recommand> fromUserRecommand;
    // 나를 추천 한 사람들 목록
    @OneToMany(mappedBy = "toUser", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Recommand> toUserRecommand;

}
