package cn.alexpy.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTests {

    @Autowired
    private IUserService userService;

    @Before
    public void init() {
        userService.init();
    }

    @Test
    public void find() {
        assertThat(userService.find("Alex")).isNotNull();
        assertThat(userService.find("Alex2")).isNull();
    }

    @Test
    public void like() {
        assertThat(userService.like("A")).isNotNull().hasSize(2);
    }

    @Test
    public void findAll() {
        assertThat(userService.findAll()).hasSize(3);
    }

    @Test
    public void delete() {
        int id = userService.find("Alex").getId();
        userService.delete(id);

        assertThat(userService.findAll()).hasSize(2);
    }

    @After
    public void deleteAll() {
        userService.deleteAll();
    }

}
