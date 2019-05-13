package hs.controller;

import hs.domain.SysLog;
import hs.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**切面的处理类
 * @Author: huangshun
 * @Date: 2019/5/13 9:16
 * @Version 1.0
 */
@Component
@Aspect
public class LogAop {
    private Date visitTime;     //开始访问的时间
    private Class clazz;        //访问的类
    private Method method;      //访问的方法
    // 注入 request
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SysLogService sysLogService;

    /**
     * 亲职通知，主要获取时间，执行的类 以及执行的是哪一个方法
     */
    @Before("execution(* hs.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
        visitTime=new Date();   //当前时间就是开始访问时间
        clazz = joinPoint.getTarget().getClass();   //具体要访问的类
        String methodName = joinPoint.getSignature().getName(); //获取要访问的方法名称
        Object[] args = joinPoint.getArgs();//获取要访问的方法的参数
        // 获取具体执行方法的method 对象
        if(args==null || args.length==0){
            method=clazz.getMethod(methodName); //只能获取无参数的方法
        }else{
            Class[] classArgs=new Class[args.length];
            for(int i=0;i<args.length;i++){
                classArgs[i]=args[i].getClass();
            }
            method = clazz.getMethod(methodName, classArgs);

        }

    }


    @After("execution(* hs.controller.*.*(..))")
    public void doAfter() throws Exception {
        long time=new Date().getTime()-visitTime.getTime(); //获取访问时长
        String url="";
        if(clazz!=null && method!=null && clazz!=LogAop.class){
            // 1 获取类上的@requestMapping("/user")
            RequestMapping classAnnotation=(RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if(classAnnotation!=null){
                String[] classValue = classAnnotation.value();
                //2.获取方法上的@RequestMapping(xxx)
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0] + methodValue[0];

                    //获取访问的ip
                    String ip = request.getRemoteAddr();

                    //获取当前操作的用户
                    SecurityContext context = SecurityContextHolder.getContext();//从上下文中获了当前登录的用户
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();

                    //将日志相关信息封装到SysLog对象
                    SysLog sysLog = new SysLog();
                    sysLog.setExecutionTime(time); //执行时长
                    sysLog.setIp(ip);
                    sysLog.setMethod("[类名] " + clazz.getName() + "[方法名] " + method.getName());
                    sysLog.setUrl(url);
                    sysLog.setUsername(username);
                    sysLog.setVisitTime(visitTime);

                    //调用Service完成操作
                    sysLogService.save(sysLog);
                }

            }



        }

    }

}
