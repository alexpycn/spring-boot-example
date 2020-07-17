package cn.alexpy.service;

import cn.alexpy.entity.User;

import java.util.List;

public interface IUserService {

    /**
     * 初始化
     */
    void init();

    /**
     * 添加用户
     * @param name
     */
    void add(String name);

    /**
     * 按用户名精确查找
     *
     * @param name
     * @return
     */
    User find(String name);

    /**
     * 按用户名模糊查找
     *
     * @param name
     * @return
     */
    List<User> like(String name);

    /**
     * 查找全部
     *
     * @return
     */
    List<User> findAll();

    /**
     * 删除
     *
     * @param id
     */
    void delete(Integer id);

    /**
     * 删除全部
     */
    void deleteAll();

}
