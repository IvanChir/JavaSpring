package com.example.aspect;

import com.example.annotation.TrackUserAction;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class UserActionAspect {

    @Pointcut("@annotation(com.example.annotation.TrackUserAction)")
    public void trackUserAction() {
    }

    @After("trackUserAction()")
    public void logUserAction(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] methodArgs = joinPoint.getArgs();
        String user = "Current User"; // Здесь можно добавить логику для получения текущего пользователя
        System.out.println("User: " + user + " called method: " + methodName + " with args: " + Arrays.toString(methodArgs));
    }
}
