package com.loeaf.file.domain;

public enum FileInfoType {
    IMAGE("IMAGE"),
    VIDEO("VIDEO");

    private String value;

    FileInfoType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}