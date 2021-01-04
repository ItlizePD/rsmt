package com.itlize.microservice.resource.entity;

import javax.persistence.*;

@Entity
@Table(name="column_added_value")
public class ColumnAddedValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;

    @ManyToOne
    @JoinColumn(name="column_id")
    private ColumnAdded columnAdded;

    private String value;

    public ColumnAddedValue() {
    }

    public ColumnAddedValue(Resource resource, ColumnAdded columnAdded) {
        this.resource = resource;
        this.columnAdded = columnAdded;
    }

    public ColumnAddedValue(Resource resource, ColumnAdded columnAdded, String value) {
        this.resource = resource;
        this.columnAdded = columnAdded;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public ColumnAdded getColumnAdded() {
        return columnAdded;
    }

    public void setColumnAdded(ColumnAdded columnAdded) {
        this.columnAdded = columnAdded;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
