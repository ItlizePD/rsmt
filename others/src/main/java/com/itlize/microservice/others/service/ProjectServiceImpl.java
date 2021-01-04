package com.itlize.microservice.others.service;


import com.itlize.microservice.others.entity.Project;
import com.itlize.microservice.others.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project findById(int projectId) {
        return projectRepository.findByProject(projectId);
    }
}
