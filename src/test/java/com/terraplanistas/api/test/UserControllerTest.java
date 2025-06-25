package com.terraplanistas.api.test;
// src/test/java/com/terraplanistas/api/controller/UserControllerTest.java
import com.terraplanistas.api.controller.UserController;
import com.terraplanistas.api.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void getAllUser_shouldReturnOk() throws Exception {
        mockMvc.perform(get("/api/user"))
                .andExpect(status().isOk());
    }
}