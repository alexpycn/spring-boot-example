package cn.alexpy.dao;

import cn.alexpy.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DaoTests {

    @Autowired
    private UserDao userDao;

    @Before
    public void init() {
        userDao.save(User.of("Alex"));
        userDao.save(User.of("Alice"));
        userDao.save(User.of("Sara"));
    }

    @Test
    public void find() {
        assertThat(userDao.findByName("Alex")).isNotNull();
        assertThat(userDao.findByName("Alex2")).isNull();
    }

    @Test
    public void like() {
        assertThat(userDao.findByNameContaining("A")).hasSize(2);
    }

    @Test
    public void findAll() {
        assertThat(userDao.findAll()).hasSize(3);
    }

    @After
    public void deleteAll() {
        userDao.deleteAll();
    }

}
