package com.loeaf.ivfm.dto.params;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PolygonMintParam {
    /**
     * file 파일 아이디
     */
    String fileInfoId;
    /**
     * NFT 고유 아이디
     */
    String tokenId;
    /**
     * 트랜젝션 해쉬
     */
    String txHash;
    /**
     * nft 종류
     */
    String symbol;
}