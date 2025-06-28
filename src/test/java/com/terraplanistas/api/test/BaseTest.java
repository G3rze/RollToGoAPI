package com.terraplanistas.api.test;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

public abstract class BaseTest {

    private static final Dotenv dotenv = Dotenv.load();

    @DynamicPropertySource
    static void registerProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", () -> dotenv.get("DB_URL"));
        registry.add("spring.datasource.username", () -> dotenv.get("DB_USER"));
        registry.add("spring.datasource.password", () -> dotenv.get("DB_PASSWORD"));
        registry.add("spring.datasource.driver-class-name", () -> dotenv.get("DB_DRIVER"));
        registry.add("server.port", () -> "0"); // Puerto aleatorio para tests
    }
}