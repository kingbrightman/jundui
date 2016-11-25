package org.yxm.jundui.service;

import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.Subject;

import java.util.List;

/**
 * Created by yxm on 2016.11.24.
 */
public interface ISubjectService {
    List<Subject> list();

    List<Subject> list(Integer[] ids);

    Pager<Subject> find();

    void add(Subject subject);

    void delete(int id);

    Subject load(int id);

    void update(Subject subject);
}
