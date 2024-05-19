package com.BlogSphere.Blog.services;

import com.BlogSphere.Blog.data.models.User;
import com.BlogSphere.Blog.data.repositories.BlogRepository;
import com.BlogSphere.Blog.data.repositories.UserRepository;
import com.BlogSphere.Blog.dtos.requests.UserRegistrationRequest;
import com.BlogSphere.Blog.exceptions.BlogException;
import com.BlogSphere.Blog.utils.ApiResponse;
import com.BlogSphere.Blog.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
        user.setRole(request.getRole());
        userRepository.save(user);

        return GenerateApiResponse.created(GenerateApiResponse.REGISTRATION_SUCCESSFUL);
    }


}