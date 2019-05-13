package hs.controller;

import hs.domain.SysLog;
import hs.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: huangshun
 * @Date: 2019/5/13 10:17
 * @Version 1.0
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogController {
    @Autowired
    private SysLogService service;


    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv=new ModelAndView();
        mv.setViewName("syslog-list");
        List<SysLog> sysLogList=service.findAll();
        mv.addObject("sysLogs",sysLogList);
        return mv;

    }
}
