package com.itlize.microservice.resource.service;


import com.itlize.microservice.resource.entity.Resource;
import com.itlize.microservice.resource.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    public ResourceRepository resourceRepository;

    @Override
    public Resource addResource(Resource resource) {
        return resourceRepository.save(resource);
    }

    @Override
    public void deleteOneResource(int resourceId) {
        resourceRepository.deleteOneResource(resourceId);
    }

    @Override
    public void deleteResourceByProject(int projectId) {
        resourceRepository.deleteResourceByProject(projectId);
    }

//    @Override
//    public List<Resource> getResourceByProjectId(int projectId, int page, int size) {
//        return resourceRepository.getResourceByProject(projectId,PageRequest.of(page,size));
//    }

    @Override
    public List<Resource> getResourceByProjectId(int projectId) {
        return resourceRepository.getResourceByProject(projectId);
    }

    @Override
    public Resource addResource(int projectId) {
        return resourceRepository.addResource(projectId);
    }

//    @Override
//    public void updateResourceName(String celValue,int resourceId ) {
//        resourceRepository.updateResourceName(celValue,resourceId);
//    }
//
//    @Override
//    public void updateResourceCode( String celValue,int resourceId) {
//        resourceRepository.updateResourceCode(celValue,resourceId);
//    }
}
