package org.reqres.config;

import io.restassured.response.Response;

public class UsersHttpRequest extends BaseHttpRequest{
    private static final String USER_URL = "/api/users/";
    private static final String POST_USER = "/api/users";

    public Response getUserById(int id) {
        return getRequestSpecification().when().get(USER_URL + id);
    }

    public Response getUserListByPageNumber(int page) {
        return getRequestSpecification().when().get(POST_USER + "?page=" + page);
    }


}
