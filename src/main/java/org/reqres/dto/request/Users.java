package org.reqres.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Users {
        private  List<User> data;

    public Users(){}

    public Users(List<User> data) {
        this.data = data;
    }
}

