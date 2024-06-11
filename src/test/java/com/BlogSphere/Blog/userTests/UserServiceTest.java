package com.BlogSphere.Blog.userTests;

import com.BlogSphere.Blog.dtos.requests.AdminLoginRequest;
import com.BlogSphere.Blog.dtos.requests.UserLoginRequest;
import com.BlogSphere.Blog.dtos.requests.UserRegistrationRequest;
import com.BlogSphere.Blog.dtos.requests.UserUpdateProfileRequest;
import com.BlogSphere.Blog.exceptions.BlogException;
import com.BlogSphere.Blog.services.interfaces.UserService;
import com.BlogSphere.Blog.utils.GenerateApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserServiceTest {
   @Autowired
   private UserService userService;

    @Test
    public void testThatUserCanRegisterUser() throws BlogException {
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setEmail("tobi4tee@gmail.com");
        request.setPassword("13071994Temmylove.");
        request.setUsername("AgboolaToby");

        assertEquals(GenerateApiResponse.created(GenerateApiResponse.REGISTRATION_SUCCESSFUL).getHttpStatus(),
                userService.registerUser(request).getHttpStatus());
    }

    @Test
    public void testThatRegisteringWithInvalidEmailFormatThrowsException(){
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setEmail("tifegrace2@gmail");
        request.setPassword("13071994Temmylove.");
        request.setUsername("Boluwatife");
        assertThrows(BlogException.class,()->userService.registerUser(request));



    }

    @Test
    public void testThatRegisteringWithInvalidPasswordFormatThrowsException(){
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setEmail("aviaAgbola@gmail.com");
        request.setPassword("00 00 00 00 00");
        request.setUsername("Aduke");
        assertThrows(BlogException.class,()->userService.registerUser(request));

    }

    @Test
    public void testThatUserCanLogin() throws BlogException {
        UserLoginRequest request = new UserLoginRequest();
        request.setEmail("tobi4tee@gmail.com");
        request.setPassword("13071994Temmylove.");

        assertEquals(GenerateApiResponse.OK(GenerateApiResponse.LOGIN_SUCCESSFULLY).getStatusCode(), userService.login(request).getStatusCode());
    }

    @Test
    public void testThatUserCanUpdateProfile() throws BlogException {
        UserUpdateProfileRequest request = new UserUpdateProfileRequest();
        request.setUserId(1L);
        request.setEmail("tobiSam@gmail.com");
        request.setPassword("tobiSam1234.");
        request.setUsername("AgboolaToby");

        assertEquals(GenerateApiResponse.updated(GenerateApiResponse.PROFILE_UPDATED_SUCCESSFULLY).getStatusCode(),
                userService.updateProfile(request).getStatusCode());
    }


}
