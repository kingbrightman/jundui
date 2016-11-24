package dao;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yxm.jundui.dao.*;
import org.yxm.jundui.model.*;

import java.util.Date;
import java.util.List;

/**
 * Created by yxm on 2016.11.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-hibernate.xml"})
public class TestUserDao {

    private static final Logger logger = Logger.getLogger(TestUserDao.class);

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IRoleDao roleDao;

    @Autowired
    private ITrainDao trainDao;

    @Autowired
    private ISubjectDao subjectDao;

    @Autowired
    private IGroupDao groupDao;


    @Test
    public void add() {
        userDao.add(new User("新兵1", "123456", "xb1", new Date()));
        userDao.add(new User("新兵2", "123456", "xb2", new Date()));
        userDao.add(new User("新兵3", "123456", "xb3", new Date()));
        userDao.add(new User("新兵4", "123456", "xb4", new Date()));
        userDao.add(new User("新兵5", "123456", "xb5", new Date()));
    }

    @Test
    public void delete() {
        userDao.delete(1);
    }

    @Test
    public void update() {
        User user = userDao.get(3);
        user.setPassword("654321");
        userDao.update(user);
    }

    public void load() {
        User user = userDao.load(3);
        System.out.println(user);
    }

    @Test
    public void get() {
        User user = userDao.get(3);
        logger.debug(user.toString());
    }

    @Test
    public void getAll() {
        List<User> users = userDao.getAll();
        for (User u : users) {
            logger.debug(u);
        }
    }

    @Test
    public void findAll() {
        Pager<User> pager = userDao.findAll();
        logger.debug(pager.getTotal());
        logger.debug(pager.getSize());
        logger.debug(pager.getOffset());
        logger.debug(pager.getDatas().size());
    }

    @Test
    public void addUserRole() {
        User user = userDao.load(3);
        Role role = roleDao.load(3);

        userDao.addUserRole(user, role);
    }

    @Test
    public void addUserTrainSubject() {
        User user = userDao.load(3);
        Train train = trainDao.load(4);
        Subject subject = subjectDao.load(5);
        userDao.addUserTrainSubject(user, train, subject);
    }

    @Test
    public void getUserTrain() {
        List<Train> list = userDao.listUserTrain(3);
        for (Train ur : list) {
            logger.debug(ur.getName());
        }
    }

    @Test
    public void getUserTrainSubject() {
        List<UserTrainSubject> list = userDao.listUserTrainSubject(3);
        for (UserTrainSubject temp : list) {
            logger.debug(temp.getTrain().getName() + "," + temp.getSubject().getName() +
                    "," + temp.getUser().getName());
        }
    }

    @Test
    public void addUserGroup() {
        Group d = groupDao.load(1);
        User u1 = userDao.load(4);
        User u2 = userDao.load(5);
        User u3 = userDao.load(6);
        User u4 = userDao.load(7);

        userDao.addUserGroup(u1, d);
        userDao.addUserGroup(u2, d);
        userDao.addUserGroup(u3, d);
        userDao.addUserGroup(u4, d);
    }
}
