package org.reqres.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.reqres.dto.request.User;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersResponseDto {

        private int page;
        private List<User> data;

        public UsersResponseDto(){}

        public UsersResponseDto(int page, List<User> data) {
            this.page = page;
            this.data = data;
        }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersResponseDto that = (UsersResponseDto) o;
        return page == that.page && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(page, data);
    }
}
