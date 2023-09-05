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
    public UserResponseDTO getUser(Long userId) {
        User user = userDAO.selectUser(userId);

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUserId(user.getUserId());
        userResponseDTO.setUserName(user.getUserName());
        userResponseDTO.setPassword(user.getPassword());
        userResponseDTO.setUserRole(user.getUserRole());

        return userResponseDTO;
    }

    @Override
    public UserResponseDTO saveUser(UserDTO userDTO) {
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        user.setUserRole(userDTO.getUserRole());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        User savedUser = userDAO.insertUser(user);

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUserId(savedUser.getUserId());
        userResponseDTO.setUserName(savedUser.getUserName());
        userResponseDTO.setPassword(savedUser.getPassword());
        userResponseDTO.setUserRole(savedUser.getUserRole());

        return userResponseDTO;
    }

    @Override
    public UserResponseDTO changeUserName(Long userId, String userName) throws Exception {
        User changeUser = userDAO.updateUserName(userId, userName);

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUserId(changeUser.getUserId());
        userResponseDTO.setUserName(changeUser.getUserName());
        userResponseDTO.setPassword(changeUser.getPassword());
        userResponseDTO.setUserRole(changeUser.getUserRole());

        return userResponseDTO;
    }

    @Override
    public void deleteUser(Long userId) throws Exception {
        userDAO.deleteUser(userId);
    }
}
