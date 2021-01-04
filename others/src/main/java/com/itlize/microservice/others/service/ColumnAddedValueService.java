package com.itlize.microservice.others.service;


import com.itlize.microservice.others.entity.ColumnAddedValue;

public interface ColumnAddedValueService {

    void addRow(ColumnAddedValue columnAddedValue);

    void updateValue(int columnId, int resourceId, String value);

    void deleteByResource(int resourceId);

    void deleteByColumn(int columnId);

    void addRow(int resourceId, int columnId);

    void addRow(int resourceId, int columnId, String value);

    ColumnAddedValue get(int columnId, int resourceId);
}
