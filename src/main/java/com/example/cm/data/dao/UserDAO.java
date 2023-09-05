package com.example.cm.data.dao;

import com.example.cm.data.entity.User;

public interface UserDAO {
    User insertUser(User user);

    User selectUser(Long userId);

    User updateUserName(Long userId, String userName) throws Exception;

    void deleteUser(Long userId) throws Exception;
}
