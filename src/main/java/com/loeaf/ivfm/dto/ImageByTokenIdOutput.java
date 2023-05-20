package com.loeaf.ivfm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageByTokenIdOutput {
    String image;
    String incense;
    String community;
    String story;
    String name;
}