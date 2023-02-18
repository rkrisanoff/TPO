package com.ts.ts.task2;

import lombok.ToString;

@ToString
public enum StatusElement {
    DELETE("DELETE"),
    CLEAR("CLEAR");

    String status;

    StatusElement(String status){
        this.status=status;
    }
}
