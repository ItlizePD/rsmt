package com.itlize.microservice.resource.controller;

import com.itlize.microservice.resource.entity.Project;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="others-service",url="http://localhost:8002")
public interface OthersFeign {

    @GetMapping("/project/{projectId}")
    Project getProject(@PathVariable int projectId);


}
