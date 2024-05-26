package com.BlogSphere.Blog.adminTests;

import com.BlogSphere.Blog.data.models.Role;
import com.BlogSphere.Blog.dtos.requests.AdminLoginRequest;
import com.BlogSphere.Blog.dtos.requests.AdminRegistrationRequest;
import com.BlogSphere.Blog.dtos.requests.AdminUpdateProfileRequest;
import com.BlogSphere.Blog.exceptions.BlogException;
import com.BlogSphere.Blog.services.interfaces.AdminService;
import com.BlogSphere.Blog.utils.GenerateApiResponse;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Nested
@SpringBootTest
public
class AdminTest {

    @Autowired
    private AdminService adminService;

    @Test
    public void testThatAdminCanRegister() throws BlogException {
        AdminRegistrationRequest request = new AdminRegistrationRequest();
        request.setName("Agboola Tobi Samuel");
        request.setPassword("agboolaToby123");
        request.setEmail("agboolaToby123@gmail.com");

        assertEquals(GenerateApiResponse.created(GenerateApiResponse.REGISTRATION_SUCCESSFUL).getStatusCode(),
                adminService.registerAdmin(request).getStatusCode());
    }

    @Test
    public void testThatMultipleAdminCanRegister() throws BlogException {
        AdminRegistrationRequest request = new AdminRegistrationRequest();
        request.setName("Agboola Avia Ayomikun");
        request.setEmail("agboolaAviaAyomikun123@gmail.com");
        request.setPassword("aviaAyomikun123");
        assertEquals(GenerateApiResponse.created(GenerateApiResponse.REGISTRATION_SUCCESSFUL).getStatusCode(),
                adminService.registerAdmin(request).getStatusCode());
    }

    @Test
    public void testThatAdminCanLogin() throws BlogException {
        AdminLoginRequest request = new AdminLoginRequest();
        request.setEmail("agboolaAviaAyomikun123@gmail.com");
        request.setPassword("aviaAyomikun123");

        assertEquals(GenerateApiResponse.OK(GenerateApiResponse.LOGIN_SUCCESSFULLY).getStatusCode(),
                adminService.login(request).getStatusCode());
    }


    @Test
    public void testThatAdminCanLogin2() throws BlogException {
        AdminLoginRequest request = new AdminLoginRequest();
        request.setEmail("agboolaToby123@gmail.com");
        request.setPassword("agboolaToby123");

        assertEquals(GenerateApiResponse.OK(GenerateApiResponse.LOGIN_SUCCESSFULLY).getStatusCode(),
                adminService.login(request).getStatusCode());

    }

    @Test
    public void testThatAdminCanUpdateProfile() throws BlogException {
        AdminUpdateProfileRequest request = new AdminUpdateProfileRequest();
        request.setId(1L);
        request.setName("Agboola Tobi Samuel");
        request.setEmail("agboolaToby123@gmail.com");
        request.setPassword("agboolaToby123");
        request.setRole(Role.GUEST);
        assertEquals(GenerateApiResponse.updated(GenerateApiResponse.PROFILE_UPDATED_SUCCESSFULLY).getStatusCode(),
                adminService.updateProfile(request).getStatusCode());
    }


}