package com.itlize.microservice.resource.service;



import com.itlize.microservice.resource.entity.Resource;

import java.util.List;


public interface ResourceService {

    Resource addResource(Resource resource);

    void deleteOneResource(int resourceId);

    void deleteResourceByProject(int projectId);

//    List<Resource> getResourceByProjectId(int projectId, int page, int size);
    List<Resource> getResourceByProjectId(int projectId);

    Resource addResource(int projectId);

//    void updateResourceName(String celValue,int resourceId);
//
//    void updateResourceCode(String celValue,int resourceId);
}

