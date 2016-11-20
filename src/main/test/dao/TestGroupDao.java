package dao;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yxm.jundui.dao.IGroupDao;
import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.Group;
import org.yxm.jundui.model.User;

import java.util.List;

/**
 * Created by yxm on 2016.11.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-hibernate.xml"})
public class TestGroupDao {

    private static final Logger logger = Logger.getLogger(TestGroupDao.class);

    @Autowired
    private IGroupDao groupDao;

    @Test
    public void add() {
        groupDao.add(new Group("团1", "步兵团1"));

        groupDao.add(new Group("营1", "步兵营1"));
        groupDao.add(new Group("营2", "步兵营2"));
        groupDao.add(new Group("营3", "步兵营3"));

        groupDao.add(new Group("连1", "步兵连1"));
        groupDao.add(new Group("连2", "步兵连2"));
        groupDao.add(new Group("连3", "步兵连3"));

        groupDao.add(new Group("连4", "步兵连4"));
        groupDao.add(new Group("连5", "步兵连5"));
        groupDao.add(new Group("连6", "步兵连6"));

        groupDao.add(new Group("连7", "步兵连7"));
        groupDao.add(new Group("连8", "步兵连8"));
        groupDao.add(new Group("连9", "步兵连9"));
    }

    @Test
    public void delete() {
        groupDao.delete(1);
    }

    @Test
    public void update() {
        Group entity = groupDao.get(4);

        Group entity1 = groupDao.get(11);
        Group entity2 = groupDao.get(12);
        Group entity3 = groupDao.get(13);

        entity1.setParent(entity);
        entity2.setParent(entity);
        entity3.setParent(entity);

        groupDao.update(entity1);
        groupDao.update(entity2);
        groupDao.update(entity3);
    }

    @Test
    public void load() {
        Group entity = groupDao.load(3);
        System.out.println(entity);
    }

    @Test
    public void get() {
        Group entity = groupDao.get(3);
        logger.debug(entity.toString());
    }

    @Test
    public void getAll() {
        List<Group> entityList = groupDao.getAll();
        for (Group u : entityList) {
            logger.debug(u);
        }
    }

    @Test
    public void findAll() {
        Pager<Group> pager = groupDao.findAll();
        logger.debug(pager.getTotal());
        logger.debug(pager.getSize());
        logger.debug(pager.getOffset());
        logger.debug(pager.getDatas().size());
    }

    @Test
    public void listGroupUsers() {
        List<User> list = groupDao.listGroupUsers(1);
        for (User u : list) {
            logger.debug(u.getName());
        }
    }


}
