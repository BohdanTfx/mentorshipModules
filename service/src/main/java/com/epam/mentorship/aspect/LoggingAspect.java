package com.epam.mentorship.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.epam.mentorship.aspect.util.AspectHelper;

@Component
@Aspect
public class LoggingAspect {
	private final static Logger LOG = Logger.getLogger(LoggingAspect.class);

	@Pointcut("@within(com.epam.mentorship.aspect.annotation.Loggable)")
	public void annotation() {
	}

	@Pointcut("execution(* com.epam.mentorship.dao.jpa.GenericJpaDao.*(..))")
	public void daoClasses() {
	}

	@Around("daoClasses() && annotation()")
	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
		String methodName = AspectHelper.getMethodName(joinPoint);
		LOG.info("Invokation started: " + joinPoint.getTarget().getClass().getName() + " -> " + methodName);
		Object returnValue = joinPoint.proceed();
		LOG.info("Invokation finished: " + joinPoint.getTarget().getClass().getName() + " -> " + methodName);
		return returnValue;
	}

	@AfterThrowing(pointcut = "daoClasses() && annotation()", throwing = "ex")
	public void afterException(JoinPoint joinPoint, Exception ex) {
		String methodName = AspectHelper.getMethodName(joinPoint);
		LOG.error("Exception was thrown on " + joinPoint.getTarget().getClass().getName() + " -> " + methodName, ex);
	}
}
