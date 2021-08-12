package com.evaluacion.configuration;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @Author: jomapozo.
 * @Datecreation: 17 dic. 2018 17:55:38
 * @FileName: AspectConfig.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: clase donde se configura los pointcut aop
 */
@Aspect
@Configuration
public class AspectConfig {

    @Pointcut("execution(public * com.evaluacion.service..*.*(..))")
    public void logServiceMethod() {}

}
