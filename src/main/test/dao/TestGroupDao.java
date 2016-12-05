package dao;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yxm.jundui.dao.GroupDao;
import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.Group;
import org.yxm.jundui.model.User;
import org.yxm.jundui.service.GroupService;

import java.util.List;

/**
 * Created by yxm on 2016.11.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-hibernate.xml"})
public class TestGroupDao {

    private static final Logger logger = Logger.getLogger(TestGroupDao.class);

    @Autowired
    private GroupDao groupDao;

    @Autowired
    private GroupService groupService;

    public void add() {
//        groupDao.updateTrainSubjects(new Group("团1", "步兵团1"));
//
//        groupDao.updateTrainSubjects(new Group("营1", "步兵营1"));
//        groupDao.updateTrainSubjects(new Group("营2", "步兵营2"));
//        groupDao.updateTrainSubjects(new Group("营3", "步兵营3"));
//
//        groupDao.updateTrainSubjects(new Group("连1", "步兵连1"));
//        groupDao.updateTrainSubjects(new Group("连2", "步兵连2"));
//        groupDao.updateTrainSubjects(new Group("连3", "步兵连3"));
//
//        groupDao.updateTrainSubjects(new Group("连4", "步兵连4"));
//        groupDao.updateTrainSubjects(new Group("连5", "步兵连5"));
//        groupDao.updateTrainSubjects(new Group("连6", "步兵连6"));
//
//        groupDao.updateTrainSubjects(new Group("连7", "步兵连7"));
//        groupDao.updateTrainSubjects(new Group("连8", "步兵连8"));
//        groupDao.updateTrainSubjects(new Group("连9", "步兵连9"));
    }

    public void delete() {
        groupDao.delete(1);
    }

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

    public void load() {
        Group entity = groupDao.load(3);
        System.out.println(entity);
    }

    public void get() {
        Group entity = groupDao.get(3);
        logger.debug(entity.toString());
    }

    public void getAll() {
        List<Group> entityList = groupDao.getAll();
        for (Group u : entityList) {
            logger.debug(u);
        }
    }

    public void findAll() {
        Pager<Group> pager = groupDao.findAll();
        logger.debug(pager.getTotal());
        logger.debug(pager.getSize());
        logger.debug(pager.getOffset());
        logger.debug(pager.getDatas().size());
    }

    public void listGroupUsers() {
        List<User> list = groupDao.listGroupUsers(1);
        for (User u : list) {
            logger.debug(u.getName());
        }
    }

    @Test
    public void listChildrenIds() {
        List<Integer> ids = groupService.listChildrenIds(3);
        for (Integer id : ids) {
            logger.debug(id + ",");
        }
    }

    @Test
    public void listChildren() {
        List<Group> ids = groupService.listChildren(3);
        for (Group id : ids) {
            logger.debug(id.getName());
        }
    }


}
