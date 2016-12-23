package org.yxm.jundui.web.dto;

import org.yxm.jundui.model.Grade;
import org.yxm.jundui.model.Subject;
import org.yxm.jundui.model.Train;

import java.util.List;

/**
 * Created by yxm on 2016.12.21.
 */
public class TrainSubjectGradesDto {
    public Train train;
    public Subject subject;
    public List<Grade> grades;
}
