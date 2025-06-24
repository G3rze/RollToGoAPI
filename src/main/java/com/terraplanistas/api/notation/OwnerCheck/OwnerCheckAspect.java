package com.terraplanistas.api.notation.OwnerCheck;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.nio.file.AccessDeniedException;

@Aspect
@Component
public class OwnerCheckAspect {

    /**
     * Define un "pointcut" que captura todas las ejecuciones de métodos
     * anotados con @OwnerCheck.
     */
    @Pointcut("@annotation(com.terraplanistas.api.notation.OwnerCheck)")
    public void ownerCheckPointcut() {
    }

    /**
     * Este método se ejecutará "Antes" (@Before) de cualquier método
     * que coincida con nuestro pointcut.
     *
     * @param joinPoint Contiene la información sobre el método interceptado.
     * @throws AccessDeniedException si la validación de propietario falla.
     */
    @Before("ownerCheckPointcut()")
    public void checkOwnership(JoinPoint joinPoint) throws AccessDeniedException {
        // 1. Obtener el UID del usuario autenticado desde el token (Contexto de Seguridad)
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new AccessDeniedException("No hay un usuario autenticado para realizar la verificación.");
        }
        // Asumimos que el "name" de la autenticación es el UID de Firebase/JWT
        String authenticatedUserId = authentication.getName();

        // 2. Obtener el ID del usuario que se envió en la petición
        // Buscamos en los argumentos del método un parámetro de tipo String que será el ID.
        String requestUserId = null;
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof String) {
                // Aquí asumimos que el primer String que encontramos es el ID del usuario.
                // Esto se puede hacer más robusto si es necesario.
                requestUserId = (String) arg;
                break;
            }
            // Podrías añadir más checks, por ejemplo si el ID fuera UUID
            // if (arg instanceof java.util.UUID) { ... }
        }

        if (requestUserId == null) {
            throw new IllegalArgumentException("No se encontró un ID de usuario en los parámetros del método para la validación de propietario.");
        }

        // 3. Comparar ambos IDs
        if (!authenticatedUserId.equals(requestUserId)) {
            // Si no coinciden, lanzamos una excepción. Spring la convertirá en un 403 Forbidden.
            throw new AccessDeniedException("Acceso denegado. No tienes permiso para modificar este recurso.");
        }

        // Si todo está bien, el método original continúa su ejecución.
    }
}