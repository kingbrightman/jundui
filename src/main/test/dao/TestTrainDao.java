package dao;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yxm.jundui.dao.IDepartmentDao;
import org.yxm.jundui.dao.ITrainDao;
import org.yxm.jundui.dao.TrainDao;
import org.yxm.jundui.model.Train;
import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.Train;

import java.util.Date;
import java.util.List;

/**
 * Created by yxm on 2016.11.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-hibernate.xml"})
public class TestTrainDao {

    private static final Logger logger = Logger.getLogger(TrainDao.class);

    @Autowired
    private ITrainDao trainDao;

    @Test
    public void add() {
        trainDao.add(new Train("体能训练1", "测试体能", new Date()));
        trainDao.add(new Train("体能训练2", "测试体能", new Date()));
        trainDao.add(new Train("体能训练3", "测试体能", new Date()));

        trainDao.add(new Train("跑步训练1", "测试跑步", new Date()));
        trainDao.add(new Train("跑步训练2", "测试跑步", new Date()));
        trainDao.add(new Train("跑步训练3", "测试跑步", new Date()));
    }

    @Test
    public void delete() {
        trainDao.delete(1);
    }

    @Test
    public void update() {
        Train entity = trainDao.get(4);
        entity.setDescription("跑步能力");
        trainDao.update(entity);
    }

    @Test
    public void load() {
        Train entity = trainDao.load(3);
        System.out.println(entity);
    }

    @Test
    public void get() {
        Train entity = trainDao.get(3);
        logger.debug(entity.toString());
    }

    @Test
    public void getAll() {
        List<Train> entityList = trainDao.getAll();
        for (Train u : entityList) {
            logger.debug(u);
        }
    }

    @Test
    public void findAll() {
        Pager<Train> pager = trainDao.findAll();
        logger.debug(pager.getTotal());
        logger.debug(pager.getSize());
        logger.debug(pager.getOffset());
        logger.debug(pager.getDatas().size());
    }


}
