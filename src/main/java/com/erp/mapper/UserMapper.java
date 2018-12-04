package com.erp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.erp.pojo.User;
import com.github.abel533.mapper.Mapper;

@Repository
public interface UserMapper extends Mapper<User> {
    /**
     * 返回所有用户的List
     *
     * @return 所有用户结果集
     */
    List<User> findAll();

    /**
     * 根据用户姓名进行查找用户信息
     *
     * @param name
     *            用户姓名
     * @return 返回当前姓名用户信息
     */
    List<User> findUserByName(String name);

    /**
     * 根据性别查找用户
     *
     * @param sex
     *            用户性别
     * @return 返回当前性别用户信息
     */
    List<User> findUserBySex(String sex);

    /**
     * 根据用户ID查找用户
     *
     * @param id
     * @return 返回当前ID的用户
     */
    User findUserById(Integer id);

    /**
     * 更新用户信息
     *
     * @param user
     *            用户信息
     */
    void updateUser(User user);

    /**
     * 新增用户
     *
     * @param user
     *            用户信息
     */
    void saveUser(User user);

    /**
     * 根据ID批量删除用户
     *
     * @param ids
     *            用户id
     */
    void deleteUser(@Param("ids") String[] ids);

    /**
     * 检测用户名重复个数
     *
     * @param user
     *            用户名
     * @return 用户个数
     */
    int checkName(User user);

}
