package com.young.application.controller;

import com.alibaba.fastjson.JSONObject;
import com.young.application.business.role.RoleService;
import com.young.application.business.user.UserService;
import com.young.application.entity.SysRole;
import com.young.application.entity.SysUserInfo;
import com.young.application.page.Pager;
import com.young.application.system.request.ResultInfo;
import com.young.application.system.request.RoleBean;
import com.young.application.system.request.UserBean;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by huiyangchen1 on 2017/6/16.
 */
@Controller
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    private RoleService roleService;




    @RequiresRoles({"admin"})
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo userList(RoleBean bean, HttpServletRequest request){
        ResultInfo info = new ResultInfo();
        Pager user = roleService.findListByPage(bean);

        info.setRows(user.getResults());
        info.setTotal(user.getTotalResult());
        return info;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String userSave(SysRole role, HttpServletRequest request){
        roleService.save(role);
        return "redirect:/role/to/list";
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo userDelete(@PathVariable("id") Long id, HttpServletRequest request){
        ResultInfo info = new ResultInfo();
        roleService.deleteById(id);
        return info;
    }

}
