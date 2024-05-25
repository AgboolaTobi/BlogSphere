package com.BlogSphere.Blog.services.implementations;

import com.BlogSphere.Blog.data.models.Role;
import com.BlogSphere.Blog.data.models.User;
import com.BlogSphere.Blog.data.repositories.UserRepository;
import com.BlogSphere.Blog.dtos.requests.UserRegistrationRequest;
import com.BlogSphere.Blog.dtos.requests.UserUpdateProfileRequest;
import com.BlogSphere.Blog.exceptions.BlogException;
import com.BlogSphere.Blog.services.interfaces.UserService;
import com.BlogSphere.Blog.utils.ApiResponse;
import com.BlogSphere.Blog.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.BlogSphere.Blog.utils.Verification.verifyEmail;
import static com.BlogSphere.Blog.utils.Verification.verifyPassword;

@Service
@AllArgsConstructor
public class UserServiceApp implements UserService {

    private final UserRepository userRepository;

    @Override
    public ApiResponse registerUser(UserRegistrationRequest request) throws BlogException {
        boolean isRegistered = userRepository.findByEmail(request.getEmail()) !=null;
        if (isRegistered) throw new BlogException(GenerateApiResponse.REGISTRATION_DETAILS_ALREADY_TAKEN);
        if (!verifyEmail(request.getEmail())) throw new BlogException(GenerateApiResponse.INVALID_EMAIL_FORMAT);
        if (!verifyPassword(request.getPassword())) throw new BlogException(GenerateApiResponse.INVALID_PASSWORD_FORMAT);
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setUsername(request.getUsername());
        user.setRole(Role.USER);
        user.setLogin(true);
        userRepository.save(user);

        return GenerateApiResponse.created(GenerateApiResponse.REGISTRATION_SUCCESSFUL);
    }

    @Override
    public ApiResponse updateProfile(UserUpdateProfileRequest request) throws BlogException {
       User existingUser = userRepository.findByEmail(request.getEmail());
       if (existingUser == null) throw new BlogException(GenerateApiResponse.INCORRECT_EMAIL);
       if (existingUser.isLogin()) throw new BlogException(GenerateApiResponse.LOGIN_TO_UPDATE_PROFILE);
       existingUser.setPassword(request.getPassword());
       existingUser.setUsername(request.getUsername());
       existingUser.setRole(Role.USER);
       existingUser.setEmail(request.getEmail());
       userRepository.save(existingUser);
        return GenerateApiResponse.updated(GenerateApiResponse.PROFILE_UPDATED_SUCCESSFULLY);
    }


}