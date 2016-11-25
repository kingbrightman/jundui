package org.yxm.jundui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yxm.jundui.dao.ISubjectDao;
import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.Subject;

import java.util.List;

/**
 * Created by yxm on 2016.11.24.
 */
@Service
public class SubjectService implements ISubjectService {

    @Autowired
    ISubjectDao subjectDao;

    @Override
    public List<Subject> list() {
        return subjectDao.list();
    }

    @Override
    public List<Subject> list(Integer[] ids) {
        return subjectDao.list(ids);
    }

    @Override
    public Pager<Subject> find() {
        return subjectDao.find();
    }

    @Override
    public void add(Subject subject) {
        subjectDao.add(subject);
    }

    @Override
    public void delete(int id) {
        subjectDao.delete(id);
    }

    @Override
    public Subject load(int id) {
        return subjectDao.load(id);
    }

    @Override
    public void update(Subject subject) {
        subjectDao.update(subject);
    }
}
