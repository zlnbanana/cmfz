package com.zln.cmfz.service;

import com.zln.cmfz.dao.LogDao;
import com.zln.cmfz.entity.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

/**
 * Created by zhanglijiao on 2018/7/10.
 */

@Aspect
public class AspectService {

    @Autowired
    private LogDao logDao;

    //声明切入点表达式
    @Pointcut("execution(* com.zln.cmfz.service.*.modify*(..)) || execution(* com.zln.cmfz.service.*.remove*(..)) || execution(* com.zln.cmfz.service.*.add*(..))")
    public void pc(){}

    /**
     * 记录增删改操作的日志
     */
    @Around("pc()")
    public Object log(ProceedingJoinPoint pjp) throws Throwable{
        Log log = new Log();
        log.setLogId(UUID.randomUUID().toString().replace("-",""));
        log.setLogTime(new Date());

        // 获取request
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // 获取Session
        HttpSession session = request.getSession();
        // 获取用户
        String userName = (String) session.getAttribute("masterName");
        log.setLogUser(userName);
        String massage = null;
        //获取 参数
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            //System.out.println(arg);
            massage += arg;
            massage += " ";
        }
        log.setLogMessage(massage);
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        //获取方法对象
        Method method = methodSignature.getMethod();
        //获取方法名称
        //System.out.println(method.getName());
        String action = method.getName();
        String firstCode = action.substring(0,1);
        if(firstCode.equals("a")){
            log.setLogAction("添加");
        }else if(firstCode.equals("m")){
            log.setLogAction("修改");
        }else {
            log.setLogAction("删除");
        }

        //获取方法所在类 及 类型
        //System.out.println(methodSignature.getDeclaringType());
        //获取方法所在类
        //System.out.println(methodSignature.getDeclaringTypeName());
        String resource = methodSignature.getDeclaringTypeName();
        String newresource = resource.substring(resource.lastIndexOf(".")+1);
        log.setLogResource(newresource);
        //获取方法的注解
//        Annotation[] annotations = method.getAnnotations();
//        for (Annotation annotation : annotations) {
//            System.out.println(annotation);
//        }
        Object obj = null;
        try {
            //调用传递
            //obj 原始方法的返回值
            obj = pjp.proceed();
            log.setLogResult("success");
        }
        catch (Throwable throwable) {
            log.setLogResult("fail");
            throwable.printStackTrace();
        }
        logDao.insertLog(log);
        return obj;
    }


}
