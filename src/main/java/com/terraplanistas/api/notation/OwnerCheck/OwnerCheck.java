package com.terraplanistas.api.notation.OwnerCheck;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anotación para verificar que el usuario autenticado es el propietario
 * del recurso que intenta modificar.
 * El ID del usuario a verificar debe pasarse como un parámetro en el método anotado.
 */
@Target(ElementType.METHOD) // Se aplicará solo a métodos
@Retention(RetentionPolicy.RUNTIME) // Estará disponible en tiempo de ejecución para que el Aspect la pueda leer
public @interface OwnerCheck {
}