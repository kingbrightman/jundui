package org.yxm.jundui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yxm.jundui.dao.SubjectDao;
import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.Subject;

import java.util.List;

/**
 * Created by yxm on 2016.11.24.
 */
@Service
public class SubjectService {

    @Autowired
    SubjectDao subjectDao;

    public List<Subject> list() {
        return subjectDao.list();
    }

    public List<Subject> list(Integer[] ids) {
        return subjectDao.list(ids);
    }

    public Pager<Subject> find() {
        return subjectDao.find();
    }

    public void add(Subject subject) {
        subjectDao.add(subject);
    }

    public void delete(int id) {
        subjectDao.delete(id);
    }

    public Subject load(int id) {
        return subjectDao.load(id);
    }

    public void update(Subject subject) {
        subjectDao.update(subject);
    }
}
