package org.reqres.dto.response;

public class SuccessRegisterResponseDto {
    private int id;
    private String token;

    public SuccessRegisterResponseDto() {}

    public SuccessRegisterResponseDto(int id, String token) {
        this.id = id;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
