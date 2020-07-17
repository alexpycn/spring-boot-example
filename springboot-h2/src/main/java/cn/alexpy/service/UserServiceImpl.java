package cn.alexpy.service;

import cn.alexpy.dao.UserDao;
import cn.alexpy.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void init() {
        deleteAll();

        userDao.save(User.of("Alex"));
        userDao.save(User.of("Alice"));
        userDao.save(User.of("Sara"));
    }

    @Override
    public void add(String name) {
        User user = User.of(name);
        userDao.save(user);
    }

    @Override
    public void delete(Integer id) {
        userDao.deleteById(id);
    }

    @Override
    public void deleteAll() {
        userDao.deleteAll();
    }

    @Override
    public User find(String name) {
        return userDao.findByName(name);
    }

    @Override
    public List<User> like(String name) {
        return userDao.findByNameContaining(name);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

}
