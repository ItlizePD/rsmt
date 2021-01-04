package com.itlize.microservice.others.entity;

import java.util.HashMap;
import java.util.Map;


public class AddedColumnView {

    private int column_id;
    private String column_name;
    private Map<Integer,String> resource_value = new HashMap<>();

    public AddedColumnView(int column_id, String column_name, Map<Integer, String> resource_value) {
        this.column_id = column_id;
        this.column_name = column_name;
        this.resource_value = resource_value;
    }
    public AddedColumnView() {
    }

    public int getColumn_id() {
        return column_id;
    }


    public void setColumn_id(int column_id) {
        this.column_id = column_id;
    }

    public String getColumn_name() {
        return column_name;
    }

    public void setColumn_name(String column_name) {
        this.column_name = column_name;
    }

    public Map<Integer, String> getResource_value() {
        return resource_value;
    }

    public void setResource_value(Map<Integer, String> resource_value) {
        this.resource_value = resource_value;
    }

    @Override
    public String toString() {
        return "AddedColumnView{" +
                "column_id=" + column_id +
                ", column_name='" + column_name + '\'' +
                ", resource_value=" + resource_value +
                '}';
    }
}
