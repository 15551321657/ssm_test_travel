package hs.controller;

import hs.domain.Role;
import hs.domain.UserInfo;
import hs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: huangshun
 * @Date: 2019/5/11 20:40
 * @Version 1.0
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv=new ModelAndView();
        System.out.println("huangshun---userFindAll被访问了---");
        List<UserInfo> userInfoList=userService.findAll();
        mv.addObject("userList",userInfoList);
        mv.setViewName("user-list");
        return mv;
    }

    /**
     * 添加一个用户(管理员信息)
     * @return
     */
    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) throws Exception {
        userService.save(userInfo);

        return "redirect:/user/findAll.do";
    }

    /**
     * 根据id查询用户详细信息
     * @return
     */
    @RequestMapping("findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv=new ModelAndView();
        UserInfo userInfo=userService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show1");

        return mv;

    }

    /**
     * 用户详情界面 跳转到给给用户添加角色信息的页面 user_role_add
     * @return
     */
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id", required=true) String id) throws Exception {
        ModelAndView mv=new ModelAndView();
        // 1 根据用户id 查询用户信息
        UserInfo userInfo = userService.findById(id);
        // 2 根据用户id 查询出该用户所没有的角色信息
        List<Role> roleList=userService.findOthersRolesByUid(id);
        mv.addObject("user",userInfo);
        mv.addObject("roleList",roleList);
        mv.setViewName("user-role-add");
        return mv;

    }

    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) String userId, @RequestParam(name = "ids",required = true) String[] roleId) throws Exception {
        userService.addRoleToUser(userId,roleId);
        return "redirect:/user/findAll.do";
    }

}
