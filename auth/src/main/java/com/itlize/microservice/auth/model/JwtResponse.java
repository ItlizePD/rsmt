package com.itlize.microservice.auth.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7654279527967960632L;
    private final String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return jwttoken;
    }
}
