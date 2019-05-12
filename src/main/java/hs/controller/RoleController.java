package hs.controller;

import hs.domain.Role;
import hs.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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



}
