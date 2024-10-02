package com.Prep.spring.Aop_logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    @Before("execution(public java.util.Optional com.Prep.spring.service.EmployeeServiceImpl.getEmployeeById(Integer))")
    public void logBeforeAdvice(JoinPoint joinPoint) {
        LOGGER.info("Entered {} with arguments: {}", joinPoint.getSignature(), joinPoint.getArgs());
        Object[] args = joinPoint.getArgs();
        LOGGER.info("With arguments: {}", (Object) args); // Casting to Object to avoid ArrayType issues
    }
}
