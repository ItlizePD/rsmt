package com.itlize.microservice.others.service;

import com.itlize.microservice.others.entity.ColumnAdded;
import com.itlize.microservice.others.repository.ColumnAddedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColumnAddedServiceImpl implements ColumnAddedService {

    @Autowired
    private ColumnAddedRepository columnAddedRepository;

    @Override
    public ColumnAdded addNewColumn(ColumnAdded columnAdded) {
        System.out.println(columnAdded);
        return columnAddedRepository.save(columnAdded);
    }

    @Override
    public List<ColumnAdded> addNewColumn(List<ColumnAdded> columnAddeds) {
        return columnAddedRepository.saveAll(columnAddeds);
    }

    @Override
    public ColumnAdded addNewColumn(String coloum_name, int project_id) {
        columnAddedRepository.addColumn(coloum_name,project_id);
        return columnAddedRepository.get(coloum_name,project_id);
    }

    @Override
    public void deleteByColumnId(int columnId) {
        columnAddedRepository.deleteColumn(columnId);
    }

    @Override
    public boolean isExist(String coloumn_name, int project_id) {
        return columnAddedRepository.get(coloumn_name,project_id)!=null;
    }

    @Override
    public void deleteByProjectId(int projectId) {
        columnAddedRepository.deleteColumn(projectId);
    }

    @Override
    public List<ColumnAdded> getColumn(int projectId) {
        System.out.println(projectId);
        return columnAddedRepository.getAllColumnByProject(projectId);
    }
}
