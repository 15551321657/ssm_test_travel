package hs.controller;

import hs.domain.Permission;
import hs.service.impl.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**资源权限的滚利页面
 * @Author: huangshun
 * @Date: 2019/5/12 14:38
 * @Version 1.0
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService service;
    @RequestMapping("findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Permission> permissionList=service.findAll();
        mv.addObject("permissionList",permissionList);
        mv.setViewName("permission-list");
        return mv;
    }

    /**
     * 新建保存一条权限信息
     * @return
     */
    @RequestMapping("save.do")
    public String save(Permission permission) throws Exception {
        service.save(permission);

        return "redirect:/permission/findAll.do";

    }


}
