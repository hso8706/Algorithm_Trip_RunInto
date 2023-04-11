package com.ssafy.service;

public enum SortType {
    
    TITLE(0), VIEW(1);
    private int type;

    SortType(int type) {
        this.type=type;
    }
}
