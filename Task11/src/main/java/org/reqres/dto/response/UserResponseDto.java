package org.reqres.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.reqres.dto.request.User;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponseDto {
    private User data;

    public UserResponseDto(){}
    public UserResponseDto(User data) {
        this.data = data;
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserResponseDto that = (UserResponseDto) o;
        return data.equals(that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
