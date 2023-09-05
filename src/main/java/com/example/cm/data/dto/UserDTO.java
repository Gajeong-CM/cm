package com.example.cm.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private String userName;
    private String password;
    private String userRole;

    public UserDTO(String userName, String password, String userRole) {
        this.userName = userName;
        this.password = password;
        this.userRole = userRole;
    }
}
