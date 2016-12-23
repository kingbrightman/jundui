package org.yxm.jundui.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.yxm.jundui.base.Constants;
import org.yxm.jundui.model.PermissionUrl;
import org.yxm.jundui.model.Role;
import org.yxm.jundui.model.User;
import org.yxm.jundui.service.RoleService;
import org.yxm.jundui.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yxm on 2016.12.05.
 */
@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "main/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        HttpServletRequest request) {

        User user = userService.loadByUserName(username);
        if (user == null) {
            request.setAttribute(Constants.ERROR_INFO, "用户不存在");
            return "main/login";
        }

        if (user.getPassword().equals(password)) {
            request.getSession().setAttribute(Constants.LOGIN_USER, user);
            initPermission(user.getId(), request);
            return "redirect:/admin/main/index";
        }

        request.setAttribute(Constants.ERROR_INFO, "用户名或密码错误");
        return "main/login";
    }

    //添加用户所有的权限导session中
    private void initPermission(int uid, HttpServletRequest request) {
        List<Integer> rids = userService.listUserRoleIds(uid);
        List<Role> loginUserRoles = userService.listUserRoles(uid);
        List<PermissionUrl> permissions = roleService.listRolesPermissions(rids);

        request.getSession().setAttribute(Constants.LOGIN_USER_PERMISSIONS, permissions);
        request.getSession().setAttribute(Constants.LOGIN_USER_ROLES, loginUserRoles);
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute(Constants.LOGIN_USER);
        request.getSession().removeAttribute(Constants.GRADE_SELECT);
        request.getSession().removeAttribute(Constants.LOGIN_USER_PERMISSIONS);
        request.getSession().removeAttribute(Constants.LOGIN_USER_ROLES);
        return "redirect:/admin/main/index";
    }
}
