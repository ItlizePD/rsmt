package com.itlize.microservice.others.entity;


public class ValueCid {
    private String value;
    private int cid;

    public ValueCid() {
    }

    public ValueCid(String value, int cid) {
        this.value = value;
        this.cid = cid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
