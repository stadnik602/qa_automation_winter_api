package org.reqres.config;

import io.restassured.response.Response;
import org.reqres.dto.request.Register;

public class RegisterHttpRequest extends BaseHttpRequest{
    private static final String REGISTER_URL = "/api/register";

    public Response registerNewClient(Register newUser) {
        return getRequestSpecification().body(newUser).when().post(REGISTER_URL);
    }
}
