package com.example.cm.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {
    private Long user_id;
    private String user_name;
    private String password;
    private String user_role;

    public UserResponseDTO() {}

    public UserResponseDTO(Long user_id, String user_name, String password, String user_role) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.password = password;
        this.user_role = user_role;
    }
}
