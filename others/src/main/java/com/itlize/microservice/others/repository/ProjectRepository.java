package com.itlize.microservice.others.repository;

import com.itlize.microservice.others.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query(value = "SELECT * FROM project WHERE project_id = ?",
            nativeQuery = true)
    Project findByProject(int projectId);


}
