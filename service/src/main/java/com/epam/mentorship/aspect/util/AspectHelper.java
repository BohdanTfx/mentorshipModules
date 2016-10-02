package com.epam.mentorship.aspect.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import com.epam.mentorship.model.BaseEntity;

public class AspectHelper {
	public static String getMethodName(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		return method.getName();
	}

	public static void executeAnnotatedMethod(BaseEntity<?> entity, Class<? extends Annotation> class1)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method[] methods = entity.getClass().getMethods();
		for (Method method : methods) {
			if (method.isAnnotationPresent(class1)) {
				method.invoke(entity);
				break;
			}
		}
	}
}
