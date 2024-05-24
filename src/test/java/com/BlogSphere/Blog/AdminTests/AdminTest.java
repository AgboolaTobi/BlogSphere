package com.BlogSphere.Blog.AdminTests;

import com.BlogSphere.Blog.dtos.requests.AdminRegistrationRequest;
import com.BlogSphere.Blog.dtos.responses.AdminRegistrationResponse;
import com.BlogSphere.Blog.exceptions.BlogException;
import com.BlogSphere.Blog.services.interfaces.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AdminTest {

    @Autowired
    private AdminService adminService;

    @Test
    public void testThatAdminCanRegister() throws BlogException {
        AdminRegistrationRequest request = new AdminRegistrationRequest();
        request.setName("Agboola Tobi Samuel");
        request.setPassword("agboolaToby123");
        request.setEmail("agboolaToby123@gmail.com");

        AdminRegistrationResponse response = adminService.registerAdmin(request);
        assertThat(response).isNotNull();
    }
}
