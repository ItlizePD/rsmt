package com.itlize.microservice.resource.entity;

import javax.persistence.*;

@Entity
@Table(name="resource")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer resource_id;

//    private String resource_name;
//
//    private String resource_code;

    @ManyToOne
    @JoinColumn(name="project_id",nullable = false)
    private Project project;

    public Resource() {
    }

    public Resource(Project project) {
        this.project = project;
    }

//    public Resource(String resource_name, String resource_code, Project project) {
//        this.resource_code = resource_code;
//        this.resource_name = resource_name;
//        this.project = project;
//    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Integer getResource_id() {
        return resource_id;
    }

    public void setResource_id(Integer resource_id) {
        this.resource_id = resource_id;
    }

//    public String getResource_code() {
//        return resource_code;
//    }
//
//    public void setResource_code(String resource_code) {
//        this.resource_code = resource_code;
//    }
//
//    public String getResource_name() {
//        return resource_name;
//    }
//
//    public void setResource_name(String resource_name) {
//        this.resource_name = resource_name;
//    }

}
