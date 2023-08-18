package com.example.cm.service;

import com.example.cm.data.dto.UserDTO;
import com.example.cm.data.dto.UserResponseDTO;

public interface UserService {
    UserResponseDTO getUser(Long user_id);

    UserResponseDTO saveUser(UserDTO userDTO);

    UserResponseDTO changeUserName(Long user_id, String user_name) throws Exception;

    void deleteUser(Long user_id) throws Exception;

}
