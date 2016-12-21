package org.yxm.jundui.web.interceptor;

import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.yxm.jundui.base.Constants;
import org.yxm.jundui.exception.CmsException;
import org.yxm.jundui.model.PermissionUrl;
import org.yxm.jundui.model.Role;
import org.yxm.jundui.model.RoleType;
import org.yxm.jundui.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by yxm on 2016.12.20.
 */
public class PermissionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        // 如果包含 admin，需要权限验证
        User loginUser = (User) request.getSession().getAttribute(Constants.LOGIN_USER);
        if (request.getRequestURL().toString().contains("/admin")) {
            if (loginUser == null) {
                response.sendRedirect(request.getContextPath() + "/login");
                return true;
            } else {
                //超级管理员判断
                List<Role> loginUserRoles = (List<Role>) request.getSession().getAttribute(Constants.LOGIN_USER_ROLES);
                for (Role role : loginUserRoles) {
                    if (role.getType() == RoleType.ROLE_ADMIN) return true;
                }

                //细粒度权限判断
                List<PermissionUrl> permissions = (List<PermissionUrl>) request.getSession().getAttribute(Constants.LOGIN_USER_PERMISSIONS);
                if (permissions != null) {
                    String url = request.getRequestURL().toString();
                    boolean havePermission = false;
                    for (PermissionUrl permission : permissions) {
                        if (url.contains(permission.getUrl())) {
                            havePermission = true;
                        }
                    }
                    if (!havePermission) {
                        throw new CmsException("没有权限");
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {

    }
}
