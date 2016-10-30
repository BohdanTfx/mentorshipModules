package com.epam.mentorship.api.tracker;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.epam.mentorship.api.model.dto.ApiResponse;
import com.epam.mentorship.api.util.MessageBuilder;

@Component
@Aspect
public class ActivityTracker {
    @Autowired
    private PublishService publishService;

    @Pointcut("@annotation(org.springframework.web.bind"
            + ".annotation.RequestMapping)")
    public void requestHandler() {
    }

    @Pointcut("@within(org.springframework.stereotype.Controller) "
            + "|| @within(org.springframework.web.bind."
            + "annotation.RestController)")
    public void controller() {
    }

    @Around("controller() && requestHandler()")
    public Object track(final ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();

        publishService.trackActivity(MessageBuilder.createMessageBuilder()
                .data(getData(result, joinPoint)).generate());

        return result;
    }

    private Object getData(final Object result,
            final ProceedingJoinPoint joinPoint) {
        if (result instanceof ApiResponse<?>) {
            ApiResponse<?> response = (ApiResponse<?>) result;
            return response.getBody();
        } else {
            for (Object arg : joinPoint.getArgs()) {
                if (arg instanceof Model) {
                    Model model = (Model) arg;
                    return model.asMap();
                }
            }
        }
        return null;
    }
}
