package com.BlogSphere.Blog.userTests;

import com.BlogSphere.Blog.data.models.Role;
import com.BlogSphere.Blog.data.repositories.UserRepository;
import com.BlogSphere.Blog.dtos.requests.UserRegistrationRequest;
import com.BlogSphere.Blog.exceptions.BlogException;
import com.BlogSphere.Blog.services.UserService;
import com.BlogSphere.Blog.utils.GenerateApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserLikesServiceTest {
   @Autowired
   private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testThatUserCanRegisterUser() throws BlogException {
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setEmail("tobi4tee@gmail.com");
        request.setRole(Role.USER);
        request.setPassword("13071994Temmylove.");
        request.setUsername("AgboolaToby");

        assertEquals(GenerateApiResponse.created(GenerateApiResponse.REGISTRATION_SUCCESSFUL).getHttpStatus(),userService.registerUser(request).getHttpStatus());
    }

    @Test
    public void testThatMoreThanOneUserCanRegister() throws BlogException {
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setEmail("tifegrace@gmail.com");
        request.setRole(Role.GUEST);
        request.setPassword("13071994Temmylove.");
        request.setUsername("Boluwatife");

        assertEquals(GenerateApiResponse.created(GenerateApiResponse.REGISTRATION_SUCCESSFUL).getHttpStatus(),userService.registerUser(request).getHttpStatus());
    }

    @Test
    public void testThatRegisteringWithInvalidEmailFormatThrowsException(){
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setEmail("tifegrace2@gmail");
        request.setRole(Role.USER);
        request.setPassword("13071994Temmylove.");
        request.setUsername("Boluwatife");
        assertThrows(BlogException.class,()->userService.registerUser(request));

    }

    @Test
    public void testThatRegisteringWithInvalidPasswordFormatThrowsException(){
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setEmail("aviaAgbola@gmail.com");
        request.setRole(Role.ADMIN);
        request.setPassword("00 00 00 00 00");
        request.setUsername("Aduke");
        assertThrows(BlogException.class,()->userService.registerUser(request));

    }

//    @Test
//    public void testThatUserCanCreateBlog() throws BlogException {
//        UserBlogCreationRequest request = new UserBlogCreationRequest();
//        request.setUserId(1L);
//        request.setUserEmail("tobi4tee@gmail.com");
//        request.setTitle("Sport Channel");
//        request.setDescription("A sport channel for all sport related news, ranging from football to volleyball");
//        request.setCategory(Category.SPORTS);
//        request.setCreatedAt(LocalDateTime.now());
//
//        assertEquals(GenerateApiResponse.created(GenerateApiResponse.BLOG_SUCCESSFULLY_CREATED).getHttpStatus(),userService.createUserBlog(request).getHttpStatus());
//
//    }


}
