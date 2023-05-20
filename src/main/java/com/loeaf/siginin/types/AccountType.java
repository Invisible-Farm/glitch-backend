package com.loeaf.siginin.types;

public enum AccountType {
    EMAIL("EMAIL"),
    FACEBOOK("FACEBOOK"),
    TWITTER("TWITTER"),
    GOOGLE("GOOGLE"),
    KAKAO("KAKAO"),
    WALLET("WALLET");

    private String value;

    AccountType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
