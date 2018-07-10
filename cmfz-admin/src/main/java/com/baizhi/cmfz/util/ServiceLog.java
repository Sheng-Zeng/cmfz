package com.baizhi.cmfz.util;

import com.baizhi.cmfz.dao.LogDAO;

import com.baizhi.cmfz.entity.LogMessage;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

/**
 * @program: cmfz
 * @description: 操作记录切入
 * @author: zs
 * @create: 2018-07-09 18:27
 **/
@Aspect
@Component
public class ServiceLog {

    @Autowired
    private LogDAO logDAO;

    @Pointcut("execution(* com.baizhi.cmfz.service..*.add*(..)) || execution(* com.baizhi.cmfz.service..*.modify*(..)) || execution(* com.baizhi.cmfz.service..*.drop*(..))")
    public void pc() {}

    @Around("pc()")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        // 获取request
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        // 获取Session
        HttpSession session = request.getSession();

        // 获取用户名
        String adminName = (String) session.getAttribute("adminName");

        // UUID
        String uuidName = UUID.randomUUID().toString().replace("-","");

        LogMessage log = new LogMessage();

        log.setLogId(uuidName);
        log.setLogUser(adminName);
        log.setLogTime(new Date());

        String totalArg = null;
        //获取参数
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            totalArg += arg;
            totalArg += " ";
        }
        log.setLogMessage(totalArg);
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        // 获取方法对象
        Method method = methodSignature.getMethod();
        // 获取方法名称
        String methodName = method.getName();

        String firstCode = methodName.substring(0,1);

        if (firstCode.equals("a")) {
           log.setLogAction("添加");
        } else if (firstCode.equals("m")) {
            log.setLogAction("修改");
        } else {
            log.setLogAction("删除");
        }
//        获取方法所在的类 及类型
//        System.out.println(methodSignature.getDeclaringType());
        // 获取方法所在的类
        String oldName = methodSignature.getDeclaringTypeName();
        String suffix = oldName.substring(oldName.lastIndexOf(".") + 1);
        log.setLogResource(suffix);
//        // 获取方法的注解
//        Annotation[] annotation = method.getAnnotations();
        Object obj = null;
        try {
            obj = pjp.proceed();
            log.setLogResult("success");
        } catch (Exception e) {
            e.printStackTrace();
            log.setLogResult("error");
        }
        logDAO.inserLog(log);
        return obj;
    }
}
