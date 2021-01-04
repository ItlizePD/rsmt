package com.itlize.microservice.resource.controller;


import com.itlize.microservice.resource.entity.Project;
import com.itlize.microservice.resource.entity.Resource;
import com.itlize.microservice.resource.entity.ResourceList;
import com.itlize.microservice.resource.entity.ValueCid;
import com.itlize.microservice.resource.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;


    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private OthersFeign othersFeign;

    @GetMapping("/add/{projectId}")
    public int addNewResource(@PathVariable int projectId){
        Project project = restTemplate.getForObject("http://others-service/project/rs-service/project/"+projectId,Project.class);
//        Project project1 = othersFeign.getProject(projectId);
//        Project project = projectService.findById(projectId);
        Resource newResource = new Resource(project);
        return resourceService.addResource(newResource).getResource_id();
    }

    @PostMapping("/add")
    public Resource addNewResource(@RequestBody Resource resource){
        return resourceService.addResource(resource);
    }

    @GetMapping("/get/{projectId}")
    public ResourceList getResourcesByProject(@PathVariable int projectId) {
        ResourceList resourceList = new ResourceList();
        resourceList.setResources(resourceService.getResourceByProjectId(projectId));
        return resourceList;
    }

    @DeleteMapping("/delete/{resourceId}")
    public void deleteOneeResource(@PathVariable int resourceId){
        resourceService.deleteOneResource(resourceId);
    }

    @DeleteMapping("/deleteByProject/{projectId}")
    public void deleteResourceByProjectId(@PathVariable int projectId){
        resourceService.deleteResourceByProject(projectId);
    }

}

