package com.itlize.microservice.others.service;



import com.itlize.microservice.others.entity.ColumnAdded;

import java.util.List;

public interface ColumnAddedService {
    boolean isExist(String coloumn_name, int project_id);

    ColumnAdded addNewColumn(ColumnAdded columnAdded);

    ColumnAdded addNewColumn(String coloumn_name, int project_id);

    List<ColumnAdded> addNewColumn(List<ColumnAdded> columnAddeds);

    void deleteByColumnId(int columnId);

    void deleteByProjectId(int projectId);

    List<ColumnAdded> getColumn(int projectId);

}
