package com.maximum.maximumpicturebackend.aop;

import com.maximum.maximumpicturebackend.annotation.AuthCheck;
import com.maximum.maximumpicturebackend.exception.BusinessException;
import com.maximum.maximumpicturebackend.exception.ErrorCode;
import com.maximum.maximumpicturebackend.model.entity.User;
import com.maximum.maximumpicturebackend.model.enums.UserRoleEnum;
import com.maximum.maximumpicturebackend.service.UserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AuthInterceptor {
    @Resource
    private UserService userService;
    @Autowired
    private ResourceUrlProvider resourceUrlProvider;

    @Around("@annotation(authCheck)")
    public Object doInterceptor(ProceedingJoinPoint joinPoint, AuthCheck authCheck) throws Throwable{
        String mustRole = authCheck.mustRole();
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        User loginUser = userService.getLoginUser(request);
        UserRoleEnum mustRoleEnum = UserRoleEnum.getEnumByValue(mustRole);
        if(mustRoleEnum == null){
            return joinPoint.proceed();
        }
        UserRoleEnum userRoleEnum = UserRoleEnum.getEnumByValue(loginUser.getUserRole());
        if(userRoleEnum == null){
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        if(UserRoleEnum.ADMIN.equals(mustRoleEnum) && !UserRoleEnum.ADMIN.equals(userRoleEnum)){
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        return joinPoint.proceed();
    }
}
