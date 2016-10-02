package com.epam.mentorship.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.epam.mentorship.aspect.annotation.BeforeSave;
import com.epam.mentorship.aspect.annotation.BeforeUpdate;
import com.epam.mentorship.aspect.util.AspectHelper;
import com.epam.mentorship.model.BaseEntity;

@Aspect
@Component
public class EntityManagerAspect {

	@Before("execution(public * com.epam.mentorship.dao.jpa.GenericJpaDao.save(..)) "
			+ "|| execution(public * com.epam.mentorship.dao.jpa.GenericJpaDao.update(..))")
	public void before(JoinPoint joinPoint) {
		BaseEntity<?> entity = findEntity(joinPoint.getArgs());
		try {
			AspectHelper.executeAnnotatedMethod(entity, getActionClass(joinPoint));
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	private Class<? extends Annotation> getActionClass(JoinPoint joinPoint) {
		Class<? extends Annotation> annotation = null;
		if ("save".equalsIgnoreCase(AspectHelper.getMethodName(joinPoint))) {
			annotation = BeforeSave.class;
		}
		if ("update".equalsIgnoreCase(AspectHelper.getMethodName(joinPoint))) {
			annotation = BeforeUpdate.class;
		}
		return annotation;
	}

	private BaseEntity<?> findEntity(Object[] args) {
		BaseEntity<?> entity = null;
		for (int i = 0; i < args.length; i++) {
			if (args[i] instanceof BaseEntity<?>) {
				entity = (BaseEntity<?>) args[i];
			}
		}
		return entity;
	}

}
