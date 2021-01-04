package com.itlize.microservice.resource.entity;

import javax.persistence.*;

@Entity
@Table(name="column_added")
public class ColumnAdded {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer column_id;

    private String column_name;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    public ColumnAdded() {
    }

    public ColumnAdded(String column_name, Project project) {
        this.column_name = column_name;
        this.project = project;
    }

    public Integer getColumn_id() {
        return column_id;
    }

    public void setColumn_id(Integer column_id) {
        this.column_id = column_id;
    }

    public String getColumn_name() {
        return column_name;
    }

    public void setColumn_name(String column_name) {
        this.column_name = column_name;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
