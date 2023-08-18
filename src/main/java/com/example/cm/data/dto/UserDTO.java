package com.example.cm.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private String user_name;
    private String password;
    private String user_role;

    public UserDTO(String user_name, String password, String user_role) {
        this.user_name = user_name;
        this.password = password;
        this.user_role = user_role;
    }
}
