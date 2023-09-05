package com.example.cm.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {
    private Long userId;
    private String userName;
    private String password;
    private String userRole;

    public UserResponseDTO() {}

    public UserResponseDTO(Long userId, String userName, String password, String userRole) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.userRole = userRole;
    }
}
