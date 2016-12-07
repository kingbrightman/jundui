package org.yxm.jundui.model;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * Created by yxm on 2016.12.06.
 */
@Entity
@Table(name = "t_grade_level")
public class GradeLevel {
    private int id;
    private Subject subject;

    private String yfrom;
    private String yto;

    private String lfrom;
    private String lto;

    private String zfrom;
    private String zto;

    private String cfrom;
    private String cto;

    public GradeLevel() {
    }

    public GradeLevel(String yfrom, String yto, String lfrom, String lto,
                      String zfrom, String zto, String cfrom, String cto) {
        this.yfrom = yfrom;
        this.yto = yto;
        this.lfrom = lfrom;
        this.lto = lto;
        this.zfrom = zfrom;
        this.zto = zto;
        this.cfrom = cfrom;
        this.cto = cto;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne(mappedBy = "level")
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
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
