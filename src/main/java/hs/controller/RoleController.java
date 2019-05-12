package hs.controller;

import hs.domain.Permission;
import hs.domain.Role;
import hs.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**角色的管理类
 * @Author: huangshun
 * @Date: 2019/5/12 14:04
 * @Version 1.0
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    // 注入service
    @Autowired
    private RoleService service;
    /**
     * 查询所有角色
     * @return
     */
    @RequestMapping("findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Role> roleList=service.findAll();
        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");
        return mv;
    }

    /**
     * 新建角色
     * @return
     */
    @RequestMapping("/save.do")
    public String save(Role role) throws Exception {
        service.save(role);

        return "redirect:/role/findAll.do";
    }


    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id",required = true) String roleId) throws Exception {
        ModelAndView mv=new ModelAndView();
        // 1 根据roleId查询角色
        Role role=service.findRoleById(roleId);
        // 2 根据roleId查询当前角色所没有的权限
        List<Permission> permissionList=service.findOthersPermission(roleId);
        mv.addObject("role",role);
        mv.addObject("permissionList",permissionList);
        mv.setViewName("role-permission-add");
        return mv;
    }

    /**
     * 给角色添加权限信息
     * @param roleId
     * @param permissionId
     * @return
     */
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name="roleId",required = true) String roleId,@RequestParam(name = "ids",required = true) String[] permissionId) throws Exception {
        service.addPermissionToRole(roleId,permissionId);

        return "redirect:findAll.do";
    }





}
