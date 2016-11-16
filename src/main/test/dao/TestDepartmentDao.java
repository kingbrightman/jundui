package dao;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yxm.jundui.dao.IDepartmentDao;
import org.yxm.jundui.dao.IRoleDao;
import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.Department;
import org.yxm.jundui.model.User;

import java.util.List;

/**
 * Created by yxm on 2016.11.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-hibernate.xml"})
public class TestDepartmentDao {

    private static final Logger logger = Logger.getLogger(TestDepartmentDao.class);

    @Autowired
    private IDepartmentDao departmentDao;

    @Test
    public void add() {
        departmentDao.add(new Department("团1", "步兵团1"));

        departmentDao.add(new Department("营1", "步兵营1"));
        departmentDao.add(new Department("营2", "步兵营2"));
        departmentDao.add(new Department("营3", "步兵营3"));

        departmentDao.add(new Department("连1", "步兵连1"));
        departmentDao.add(new Department("连2", "步兵连2"));
        departmentDao.add(new Department("连3", "步兵连3"));

        departmentDao.add(new Department("连4", "步兵连4"));
        departmentDao.add(new Department("连5", "步兵连5"));
        departmentDao.add(new Department("连6", "步兵连6"));

        departmentDao.add(new Department("连7", "步兵连7"));
        departmentDao.add(new Department("连8", "步兵连8"));
        departmentDao.add(new Department("连9", "步兵连9"));
    }

    @Test
    public void delete() {
        departmentDao.delete(1);
    }

    @Test
    public void update() {
        Department entity = departmentDao.get(4);

        Department entity1 = departmentDao.get(11);
        Department entity2 = departmentDao.get(12);
        Department entity3 = departmentDao.get(13);

        entity1.setParent(entity);
        entity2.setParent(entity);
        entity3.setParent(entity);

        departmentDao.update(entity1);
        departmentDao.update(entity2);
        departmentDao.update(entity3);
    }

    @Test
    public void load() {
        Department entity = departmentDao.load(3);
        System.out.println(entity);
    }

    @Test
    public void get() {
        Department entity = departmentDao.get(3);
        logger.debug(entity.toString());
    }

    @Test
    public void getAll() {
        List<Department> entityList = departmentDao.getAll();
        for (Department u : entityList) {
            logger.debug(u);
        }
    }

    @Test
    public void findAll() {
        Pager<Department> pager = departmentDao.findAll();
        logger.debug(pager.getTotal());
        logger.debug(pager.getSize());
        logger.debug(pager.getOffset());
        logger.debug(pager.getDatas().size());
    }

    @Test
    public void listDepartmentUsers() {
        List<User> list = departmentDao.listDepartmentUsers(1);
        for (User u : list) {
            logger.debug(u.getName());
        }
    }


}
