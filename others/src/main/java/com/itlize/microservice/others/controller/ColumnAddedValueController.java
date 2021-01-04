package com.itlize.microservice.others.controller;


import com.itlize.microservice.others.entity.ColumnAddedValue;
import com.itlize.microservice.others.service.ColumnAddedValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/otherColumnsValue")
public class ColumnAddedValueController {

    @Autowired
    private ColumnAddedValueService columnAddedValueService;

    @PostMapping("/add")
    public void add(@RequestBody ColumnAddedValue columnAddedValue){
        columnAddedValueService.addRow(columnAddedValue);
    }

    @GetMapping("/add/{resourceId}/{columnId}")
    public void add(@PathVariable int resourceId, @PathVariable int columnId){
        columnAddedValueService.addRow(resourceId, columnId);
    }


    @PostMapping("/update/{resourceId}/{columnId}")
    public void update(@RequestBody String value, @PathVariable int resourceId, @PathVariable int columnId){
        columnAddedValueService.updateValue(columnId,resourceId,value);
    }

    @DeleteMapping("/deleteByColumn/{columnId}")
    public void deleteByColumn(@PathVariable int columnId){
        columnAddedValueService.deleteByColumn(columnId);
    }

    @DeleteMapping("/deleteByResource/{resourceId}")
    public void deleteByResource(@PathVariable int resourceId){
        columnAddedValueService.deleteByResource(resourceId);
    }

    @GetMapping("/get/{resourceId}/{columnId}")
    public ColumnAddedValue getValue(@PathVariable int resourceId, @PathVariable int columnId){
        return columnAddedValueService.get(columnId,resourceId);
    }
}
