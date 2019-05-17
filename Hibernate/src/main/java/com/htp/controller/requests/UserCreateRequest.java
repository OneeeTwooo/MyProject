package com.htp.controller.requests;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Objects;

public class UserCreateRequest {

    @NotNull
    @NotEmpty
    @Size(min = 6, max = 20)
    private String userName;

    @Pattern(regexp = "\\d{3}")
    private String userSurname;

    public UserCreateRequest() {
    }

    public UserCreateRequest(String userName, String userSurname, Timestamp birthDate, Long departmentId) {
        this.userName = userName;
        this.userSurname = userSurname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCreateRequest that = (UserCreateRequest) o;
        return Objects.equals(userName, that.userName) &&
                Objects.equals(userSurname, that.userSurname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, userSurname);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
