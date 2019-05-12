package hs.controller;

import hs.domain.UserInfo;
import hs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
