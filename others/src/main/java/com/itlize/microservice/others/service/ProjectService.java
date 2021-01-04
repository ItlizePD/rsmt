package com.itlize.microservice.others.service;


import com.itlize.microservice.others.entity.Project;

import java.util.List;


public interface ProjectService {

    Project findById(int projectId);

    List<Project> findAll();

}
