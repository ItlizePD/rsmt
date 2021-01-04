package com.itlize.microservice.resource.entity;

import javax.persistence.*;

@Entity
@Table(name="project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer project_id;

    private String project_name;


//    @OneToMany(mappedBy = "project",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    private List<Resource> resources;
//
//    @OneToMany(mappedBy = "project",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    private List<ColumnAdded> columnAddeds;

    public Project() {
    }

//    public List<Resource> getResources() {
//        return resources;
//    }
//
//    public void setResources(List<Resource> resources) {
//        this.resources = resources;
//    }
//
//    public List<ColumnAdded> getColumnAddeds() {
//        return columnAddeds;
//    }
//
//    public void setColumnAddeds(List<ColumnAdded> columnAddeds) {
//        this.columnAddeds = columnAddeds;
//    }

    public Project(String project_name) {
        this.project_name = project_name;
    }

    public Integer getProject_id() {
        return project_id;
    }

    public String getProject_name() {
        return project_name;
    }
    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }
}
