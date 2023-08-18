package com.example.cm.service.impl;

import com.example.cm.data.dao.UserDAO;
import com.example.cm.data.dao.impl.UserDAOImpl;
import com.example.cm.data.dto.UserDTO;
import com.example.cm.data.dto.UserResponseDTO;
import com.example.cm.data.entity.User;
import com.example.cm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserResponseDTO getUser(Long user_id) {
        User user = userDAO.selectUser(user_id);

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUser_id(user.getUser_id());
        userResponseDTO.setUser_name(user.getUser_name());
        userResponseDTO.setPassword(user.getPassword());
        userResponseDTO.setUser_role(user.getUser_role());

        return userResponseDTO;
    }

    @Override
    public UserResponseDTO saveUser(UserDTO userDTO) {
        User user = new User();
        user.setUser_name(userDTO.getUser_name());
        user.setPassword(userDTO.getPassword());
        user.setUser_role(userDTO.getUser_role());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        User savedUser = userDAO.insertUser(user);

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUser_id(savedUser.getUser_id());
        userResponseDTO.setUser_name(savedUser.getUser_name());
        userResponseDTO.setPassword(savedUser.getPassword());
        userResponseDTO.setUser_role(savedUser.getUser_role());

        return userResponseDTO;
    }

    @Override
    public UserResponseDTO changeUserName(Long user_id, String user_name) throws Exception {
        User changeUser = userDAO.updateUserName(user_id, user_name);

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUser_id(changeUser.getUser_id());
        userResponseDTO.setUser_name(changeUser.getUser_name());
        userResponseDTO.setPassword(changeUser.getPassword());
        userResponseDTO.setUser_role(changeUser.getUser_role());

        return userResponseDTO;
    }

    @Override
    public void deleteUser(Long user_id) throws Exception {
        userDAO.deleteUser(user_id);
    }
}
