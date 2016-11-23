package org.yxm.jundui.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by yxm on 2016.11.23.
 */
public class TestValidation {

    @NotEmpty(message = "不能为空")
    @NotNull(message = "不能为空")
    private String name;

    @Email(message = "格式不正确")
    private String email;

    public TestValidation() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
