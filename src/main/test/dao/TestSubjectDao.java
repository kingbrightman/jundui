package dao;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yxm.jundui.dao.SubjectDao;
import org.yxm.jundui.dao.TrainDao;
import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.Subject;

import java.util.List;

/**
 * Created by yxm on 2016.11.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-hibernate.xml"})
public class TestSubjectDao {

    private static final Logger logger = Logger.getLogger(TrainDao.class);

    @Autowired
    private SubjectDao subjectDao;

    @Test
    public void add() {
//        subjectDao.updateTrainSubjects(new Subject("跳高", "跳跃高度", "float"));
//        subjectDao.updateTrainSubjects(new Subject("跳远", "跳跃长度", "float"));
//        subjectDao.updateTrainSubjects(new Subject("引体向上", "次数", "int"));
//        subjectDao.updateTrainSubjects(new Subject("100米", "跑步", "time"));
//        subjectDao.updateTrainSubjects(new Subject("400米", "跑步", "time"));
//        subjectDao.updateTrainSubjects(new Subject("五公里越野", "跑步", "time"));
    }

    @Test
    public void delete() {
        subjectDao.delete(1);
    }

    @Test
    public void update() {
        Subject entity = subjectDao.get(4);
        entity.setDescription("跑步能力");
        subjectDao.update(entity);
    }

    @Test
    public void load() {
        Subject entity = subjectDao.load(3);
        System.out.println(entity.getDescription());
    }

    @Test
    public void get() {
        Subject entity = subjectDao.get(3);
        logger.debug(entity.toString());
    }

    @Test
    public void getAll() {
        List<Subject> entityList = subjectDao.getAll();
        for (Subject u : entityList) {
            logger.debug(u);
        }
    }

    @Test
    public void findAll() {
        Pager<Subject> pager = subjectDao.findAll();
        logger.debug(pager.getTotal());
        logger.debug(pager.getSize());
        logger.debug(pager.getOffset());
        logger.debug(pager.getDatas().size());
    }


}
