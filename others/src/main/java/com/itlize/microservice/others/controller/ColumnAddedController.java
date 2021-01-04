package com.itlize.microservice.others.controller;

import com.itlize.microservice.others.entity.AddedColumnView;
import com.itlize.microservice.others.entity.ColumnAdded;
import com.itlize.microservice.others.entity.Resource;
import com.itlize.microservice.others.entity.ResourceList;
import com.itlize.microservice.others.service.ColumnAddedService;
import com.itlize.microservice.others.service.ColumnAddedValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/otherColumns")
public class ColumnAddedController {
    @Autowired
    private ColumnAddedService columnAddedService;

    @Autowired
    private ColumnAddedValueService columnAddedValueService;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/get/{projectId}")
    public List<AddedColumnView> getAddedColumnByProject(@PathVariable int projectId){
        List<AddedColumnView> result = new ArrayList<>();
        List<ColumnAdded> columnAddeds = columnAddedService.getColumn(projectId);
        System.out.println(columnAddeds);

        List<Resource> resourceList = restTemplate.getForObject("http://resource-service/resource/get/"+projectId, ResourceList.class).getResources();
        System.out.println(resourceList);
        for(ColumnAdded columnAdded:columnAddeds){
            int column_id = columnAdded.getColumn_id();
            String column_name = columnAdded.getColumn_name();

            AddedColumnView addedColumnView = new AddedColumnView();
            addedColumnView.setColumn_id(column_id);
            addedColumnView.setColumn_name(column_name);
            for(Resource resource:resourceList){
                System.out.println(column_id);
                System.out.println(resource.getResource_id());
                if(columnAddedValueService.get(column_id,resource.getResource_id())!=null) {
                    String value = columnAddedValueService.get(column_id, resource.getResource_id()).getValue();
                    System.out.println(value);
                    if (value == null) value = "";
                    addedColumnView.getResource_value().put(resource.getResource_id(), value);
                }
            }
            System.out.println(addedColumnView);
            result.add(addedColumnView);
        }
        return result;
    }

    @GetMapping("add/{projectId}/{columnName}")
    public ColumnAdded addColumn(@PathVariable int projectId, @PathVariable String columnName){
        List<Resource> resourceList = restTemplate.getForObject("http://resource-service/resource/get/"+projectId, ResourceList.class).getResources();
        ColumnAdded newColumn = columnAddedService.addNewColumn(columnName,projectId);
        for(Resource resource:resourceList){
            columnAddedValueService.addRow(resource.getResource_id(),newColumn.getColumn_id());
        }
        return newColumn;
    }

    @DeleteMapping("delete/{columnId}")
    public void deleteOneColumn(@PathVariable int columnId){
        columnAddedValueService.deleteByColumn(columnId);
        columnAddedService.deleteByColumnId(columnId);
    }

    @DeleteMapping("deleteAll/{projectId}")
    public void deleteColumns(@PathVariable int projectId){
        columnAddedService.deleteByProjectId(projectId);
    }
}
