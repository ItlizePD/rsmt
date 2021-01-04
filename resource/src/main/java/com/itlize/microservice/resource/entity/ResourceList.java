package com.itlize.microservice.resource.entity;

import java.util.ArrayList;
import java.util.List;

public class ResourceList {

    private List<Resource> resources;

    public ResourceList(List<Resource> resources) {
        this.resources = resources;
    }

    public ResourceList() {
        resources = new ArrayList<>();
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}
