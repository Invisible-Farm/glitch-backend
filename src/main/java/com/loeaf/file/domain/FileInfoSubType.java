package com.loeaf.file.domain;

public enum FileInfoSubType {
    INCENSE("INCENSE"),
    PROOFOFVALUE("PROOFOFVALUE");

    private String value;

    FileInfoSubType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}