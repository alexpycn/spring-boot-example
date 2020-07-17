package cn.alexpy.dao;

import cn.alexpy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 */
public interface UserDao extends JpaRepository<User, Integer> {

    /* 精确查找 */
    User findByName(String name);

    /* 模糊查找 */
    List<User> findByNameStartsWith(String name);

    List<User> findByNameContaining(String name);

    List<User> findTop5ByNameContaining(String name);

}
