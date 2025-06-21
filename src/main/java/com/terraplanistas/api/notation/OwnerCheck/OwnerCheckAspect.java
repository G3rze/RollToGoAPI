package com.terraplanistas.api.notation.OwnerCheck;

import com.google.firebase.auth.FirebaseToken;
import com.terraplanistas.api.service.ResourceOwnerService;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Aspect
@Component
public class OwnerCheckAspect {

    @Autowired
    private ResourceOwnerService resourceOwnerService;

    @Around("@annotation(ownerCheck)")
    public Object verificarPropietario(ProceedingJoinPoint joinPoint, OwnerCheck ownerCheck) throws Throwable {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();
        FirebaseToken user = (FirebaseToken) request.getAttribute("firebaseUser");

        String uid = user.getUid();

        // Obtener el ID del recurso del parámetro del método
        Object[] args = joinPoint.getArgs();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String[] paramNames = signature.getParameterNames();

        UUID id = null;
        for (int i = 0; i < paramNames.length; i++) {
            if (paramNames[i].equals(ownerCheck.idParam())) {
                id = UUID.fromString(args[i].toString());
                break;
            }
        }

        if (id == null || !resourceOwnerService.isOwner(id, uid)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "No eres el propietario del recurso");
        }

        return joinPoint.proceed();
    }
}
