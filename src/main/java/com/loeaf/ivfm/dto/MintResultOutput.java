package com.loeaf.ivfm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MintResultOutput {
    String fileInfoId;
    String Recipient;
    String symbol;
}