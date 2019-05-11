package hs.controller;

import com.github.pagehelper.PageInfo;
import hs.domain.Orders;
import hs.service.OrdersService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**订单的controller
 * @Author: huangshun
 * @Date: 2019/5/11 9:27
 * @Version 1.0
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {
    // 注入service
    @Autowired
    private OrdersService ordersService;

    /**
     * 查询所有订单信息
     * @return
     */
/*    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Orders> ordersList = ordersService.findAll();
        mv.addObject("ordersList",ordersList);
        mv.setViewName("orders-list");

        return mv;
    }*/


    /**
     * 分页查询所有订单
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true, defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize", required = true, defaultValue = "4")Integer pageSize) throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Orders> ordersList = ordersService.findByPage(page,pageSize);
        PageInfo pageInfo=new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");

        return mv;
    }
}
