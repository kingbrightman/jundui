package org.yxm.jundui.web.dto;

import org.yxm.jundui.model.GradeLevel;
import org.yxm.jundui.model.Subject;
import org.yxm.jundui.model.SubjectType;

/**
 * Created by yxm on 2016.12.06.
 */
public class SubjectDto {

    private int id;

    private String name;
    private String description;
    private SubjectType type;

    private String yfrom;
    private String yto;

    private String lfrom;
    private String lto;

    private String zfrom;
    private String zto;

    private String cfrom;
    private String cto;

    public SubjectDto() {
    }

    public Subject getSubject() {
        Subject subject = new Subject();
        subject.setId(this.getId());
        subject.setName(this.getName());
        subject.setDescription(this.getDescription());
        subject.setType(this.getType());

        GradeLevel level = new GradeLevel(yfrom, yto, lfrom, lto, zfrom, zto, cfrom, cto);
        subject.setLevel(level);
        return subject;
    }

    public SubjectDto(Subject subject, GradeLevel gradeLevel) {
        this.setId(subject.getId());
        this.setName(subject.getName());
        this.setDescription(subject.getDescription());
        this.setType(subject.getType());

        this.setYfrom(gradeLevel.getYfrom());
        this.setYto(gradeLevel.getYto());
        this.setLfrom(gradeLevel.getLfrom());
        this.setLto(gradeLevel.getLto());
        this.setZfrom(gradeLevel.getZfrom());
        this.setZto(gradeLevel.getZto());
        this.setCfrom(gradeLevel.getCfrom());
        this.setCto(gradeLevel.getCto());
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SubjectType getType() {
        return type;
    }

    public void setType(SubjectType type) {
        this.type = type;
    }

    public String getYfrom() {
        return yfrom;
    }

    public void setYfrom(String yfrom) {
        this.yfrom = yfrom;
    }

    public String getYto() {
        return yto;
    }

    public void setYto(String yto) {
        this.yto = yto;
    }

    public String getLfrom() {
        return lfrom;
    }

    public void setLfrom(String lfrom) {
        this.lfrom = lfrom;
    }

    public String getLto() {
        return lto;
    }

    public void setLto(String lto) {
        this.lto = lto;
    }

    public String getZfrom() {
        return zfrom;
    }

    public void setZfrom(String zfrom) {
        this.zfrom = zfrom;
    }

    public String getZto() {
        return zto;
    }

    public void setZto(String zto) {
        this.zto = zto;
    }

    public String getCfrom() {
        return cfrom;
    }

    public void setCfrom(String cfrom) {
        this.cfrom = cfrom;
    }

    public String getCto() {
        return cto;
    }

    public void setCto(String cto) {
        this.cto = cto;
    }


}
