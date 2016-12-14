package dao;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.yxm.jundui.dao.RoleDao;
import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.Role;

import java.util.List;

/**
 * Created by yxm on 2016.11.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-hibernate.xml"})
public class TestRoleDao {

    private static final Logger logger = Logger.getLogger(TestRoleDao.class);

    @Autowired
    private RoleDao roleDao;

    @Transactional
    @Test
    public void add() {
        roleDao.add(new Role("普通用户1", "只能查看数据"));
    }

    @Test
    public void delete() {
        roleDao.delete(1);
    }

    @Test
    public void update() {
        Role entity = roleDao.get(3);
        roleDao.update(entity);
    }

    @Test
    public void load() {
        Role entity = roleDao.load(3);
        System.out.println(entity);
    }

    @Test
    public void get() {
        Role entity = roleDao.get(3);
        logger.debug(entity.toString());
    }

    @Test
    public void getAll() {
        List<Role> entityList = roleDao.getAll();
        for (Role u : entityList) {
            logger.debug(u);
        }
    }

    @Test
    public void findAll() {
        Pager<Role> pager = roleDao.findAll();
        logger.debug(pager.getTotal());
        logger.debug(pager.getSize());
        logger.debug(pager.getOffset());
        logger.debug(pager.getDatas().size());
    }


}
