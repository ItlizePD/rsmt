package com.itlize.microservice.others.service;


import com.itlize.microservice.others.entity.ColumnAddedValue;
import com.itlize.microservice.others.repository.ColumnAddedValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColumnAddedValueServiceImpl implements ColumnAddedValueService{

    @Autowired
    private ColumnAddedValueRepository columnAddedValueRepository;

    @Override
    public void addRow(ColumnAddedValue columnAddedValue) {
        columnAddedValueRepository.save(columnAddedValue);
    }

    @Override
    public void updateValue(int columnId, int resourceId, String value) {
        columnAddedValueRepository.update(value,resourceId,columnId);
    }

    @Override
    public void deleteByResource(int resourceId) {
        columnAddedValueRepository.deleteByResouce(resourceId);
    }

    @Override
    public void addRow(int resourceId, int columnId) {
        columnAddedValueRepository.addRow(resourceId,columnId);
    }

    @Override
    public void addRow(int resourceId, int columnId, String value) {
        columnAddedValueRepository.addRow(resourceId,columnId,value);
    }

    @Override
    public ColumnAddedValue get(int columnId, int resourceId) {
        return columnAddedValueRepository.get(columnId,resourceId);
    }

    @Override
    public void deleteByColumn(int columnId) {
        columnAddedValueRepository.deleteByColumn(columnId);
    }
}
