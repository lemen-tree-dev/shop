package com.shop.dao;

import com.shop.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HeXiaoH
 * @date 2019/11/9 11:12
 */
@Mapper
public interface UserDao {
    /**
     * 根据用户名查找用户
     * @param userName
     * @return
     */
    public User findUserByName(String userName);

    /**
     * 根据电话查找用户
     * @param userTelephone
     * @return
     */
    public User findUserByTel(@Param("userTelephone") String userTelephone);

    /**
     * 根据邮箱查找用户
     * @param userEmail
     * @return
     */
    public User findUserByEmail(@Param("userEmail") String userEmail);


    /**
     * 注册用户
     * @param user
     * @return
     */
    public int insertUser(User user);

    /**
     * 查询全部
     * @return
     */
    public List<User> findAll();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public User findById(int id);

    /**
     *
     * 修改用户信息
     * @param user
     * @return
     */
    public int updateById(User user);
}
