package com.loeaf.ivfm.model;

public enum NftType {
    PSBT("PSBT"),
    IFT("IFT"),
    GFT("GFT");

    private String value;

    NftType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
