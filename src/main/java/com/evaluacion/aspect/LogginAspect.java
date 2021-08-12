package com.evaluacion.aspect;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.util.StopWatch;

import com.evaluacion.common.util.Constant;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @Author: jomapozo.
 * @Datecreation: 17 dic. 2018 17:55:13
 * @FileName: LogginAspect.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: clase logger usando aop
 */
@Configuration
@Aspect
public class LogginAspect {

    @Autowired
    private Environment environment;

    @Autowired
    private ObjectMapper objMapper;

    private static Logger logger = LogManager.getLogger(LogginAspect.class);

    
    @Before("com.evaluacion.configuration.AspectConfig.logServiceMethod()")
    public void logBeforeWebFactoryMethod(JoinPoint joinPoint) throws Throwable {

	StringBuilder log = new StringBuilder();
	MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
	String methodName = joinPoint.getSignature().getName();
	String className = joinPoint.getTarget().getClass().getName();
	log.append(Constant.CLASS_LOG_LABEL);
	log.append(className);
	log.append(Constant.NEW_LINE);
	log.append(Constant.METHOD_LOG_LABEL);
	log.append(methodName);
	log.append(Constant.PARAMETERS_LOG_LABEL);
	log.append(Constant.NEW_LINE);
	log.append(Constant.INPUT_PARAMETER_LABEL);
	log.append(Constant.NEW_LINE);
	Object[] args = joinPoint.getArgs();
	String[] argNames = methodSignature.getParameterNames();
	int i = 0;
	for (String argName : argNames) {
	    try {
		String type = args[i].getClass().getSimpleName();
		log.append(String.format("-[%s] %s = [%s]".concat(Constant.NEW_LINE), type, argName, args[i]));
	    } catch (Exception e) {
		log.append(Constant.PARSE_JSON_RESPONSE);
		log.append(Constant.NEW_LINE);
	    }
	    i++;
	}
	logInfo(log.toString());
    }

    private static void logInfo(String log) {
	StringBuilder finalLog = new StringBuilder();
	finalLog.append(getHeaderForLog());
	finalLog.append(log);
	finalLog.append(getFooterLog());
	logger.info(finalLog.toString());
    }

    private static String getHeaderForLog() {
	StringBuilder headerLog = new StringBuilder();

	headerLog.append(Constant.NEW_LINE + Constant.SEPARATOR + Constant.NEW_LINE);
	headerLog.append("[TrackingID]: ");
	//headerLog.append(UtilLog.getTracking());
	headerLog.append(Constant.NEW_LINE);
	headerLog.append("[Date]: ");
	headerLog.append(new Date());
	headerLog.append(Constant.NEW_LINE);
	headerLog.append("[Time]: ");
	//headerLog.append(TotalUtil.getDateFormat(new Date(), Constant.TIME));
	headerLog.append(Constant.NEW_LINE + "" + Constant.NEW_LINE);
	return headerLog.toString();
    }

    private static String getFooterLog() {
	return Constant.SEPARATOR;
    }

    private static void logInfo(String log, StopWatch watch) {
	StringBuilder finalLog = new StringBuilder();
	finalLog.append(getHeaderForLog(watch));
	finalLog.append(log);
	finalLog.append(getFooterLog());
	logger.info(finalLog.toString());
    }

    private static String getHeaderForLog(StopWatch watch) {

	StringBuilder headerLog = new StringBuilder();

	headerLog.append(Constant.NEW_LINE + Constant.SEPARATOR + Constant.NEW_LINE);
	headerLog.append("[TrackingID]: ");
	//headerLog.append(UtilLog.getTracking());
	headerLog.append(Constant.NEW_LINE);
	headerLog.append("[Excecution Date]: ");
	headerLog.append(new Date());
	headerLog.append(Constant.NEW_LINE);
	headerLog.append("[Excecution Time]: ");
	//headerLog.append(TotalUtil.getDateFormat(new Date(), Constant.TIME));
	headerLog.append(Constant.NEW_LINE);
	headerLog.append("[Measure Method Time]: ");
	headerLog.append(watch.getTotalTimeMillis());
	headerLog.append(Constant.NEW_LINE + "" + Constant.NEW_LINE);
	return headerLog.toString();
    }

}
