package org.reqres.config;

import io.restassured.response.Response;
import org.reqres.dto.request.Login;

public class LoginHttpRequest extends BaseHttpRequest {
    private static final String LOGIN_URL = "/api/login";

    public Response login(Login client) {
        return getRequestSpecification().body(client).when().post(LOGIN_URL);
    }
}
