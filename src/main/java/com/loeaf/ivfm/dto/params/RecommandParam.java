package com.loeaf.ivfm.dto.params;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecommandParam {
    String communityId;
    String from;
    String to;
    String incenseUuid;
    String incenseImgUuid;
    String profOfValueUuid;
    String profOfValueSumnailUuid;
    String story;
    String myResponse;
}