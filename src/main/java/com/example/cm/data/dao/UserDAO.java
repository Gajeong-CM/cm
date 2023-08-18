package com.example.cm.data.dao;

import com.example.cm.data.entity.User;

public interface UserDAO {
    User insertUser(User user);

    User selectUser(Long user_id);

    User updateUserName(Long user_id, String user_name) throws Exception;

    void deleteUser(Long user_id) throws Exception;
}
