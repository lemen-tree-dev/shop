package com.shop.service;

import com.shop.domain.User;

import java.util.List;

/**
 * @author HeXiaoH
 * @date 2019/11/9 14:11
 */
public interface UserService {
    public User findUser(User user);

    public User findUserByTel(String userTelephone);

    public String sendCode(String userTelephone);

    public String insertUser(User user);

    public List<User> findAll();

    public User findById(int id);

    public int updateById(User user);
}
