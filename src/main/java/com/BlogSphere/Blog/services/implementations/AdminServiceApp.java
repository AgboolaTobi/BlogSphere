package com.BlogSphere.Blog.services.implementations;

import com.BlogSphere.Blog.data.models.Admin;
import com.BlogSphere.Blog.data.models.Role;
import com.BlogSphere.Blog.data.repositories.AdminRepository;
import com.BlogSphere.Blog.dtos.requests.AdminLoginRequest;
import com.BlogSphere.Blog.dtos.requests.AdminRegistrationRequest;
import com.BlogSphere.Blog.dtos.requests.AdminUpdateProfileRequest;
import com.BlogSphere.Blog.exceptions.BlogException;
import com.BlogSphere.Blog.services.interfaces.AdminService;
import com.BlogSphere.Blog.utils.ApiResponse;
import com.BlogSphere.Blog.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class AdminServiceApp implements AdminService {
    private final AdminRepository adminRepository;

    @Override
    public ApiResponse registerAdmin(AdminRegistrationRequest request) throws BlogException {
        boolean isRegistered = adminRepository.findByEmail(request.getEmail())!=null;
        if (isRegistered) throw new BlogException(GenerateApiResponse.REGISTRATION_DETAILS_ALREADY_TAKEN);
        Admin admin = new Admin();
        admin.setName(request.getName());
        admin.setEmail(request.getEmail());
        admin.setPassword(request.getPassword());
        admin.setRole(Role.ADMIN);
        admin.setCreatedAt(LocalDateTime.now());
        adminRepository.save(admin);
        return GenerateApiResponse.created(GenerateApiResponse.ADMIN_SUCCESSFULLY_REGISTERED);
    }

    @Override
    public ApiResponse login(AdminLoginRequest request) throws BlogException {
        Admin existingAdmin = adminRepository.findByEmail(request.getEmail());
        if (existingAdmin==null) throw new BlogException(GenerateApiResponse.INCORRECT_EMAIL);
        if (!existingAdmin.getPassword().equals(request.getPassword())) throw new BlogException(GenerateApiResponse.LOGIN_TO_UPDATE_PROFILE);

        existingAdmin.setLogin(true);
        adminRepository.save(existingAdmin);

        return GenerateApiResponse.OK(GenerateApiResponse.LOGIN_SUCCESSFULLY);
    }

    @Override
    public ApiResponse updateProfile(AdminUpdateProfileRequest request) throws BlogException {
        Admin existingAdmin = adminRepository.findById(request.getId()).orElse(null);
        if (existingAdmin==null) throw new BlogException(GenerateApiResponse.ADMIN_NOT_FOUND);
        if (!existingAdmin.isLogin()) throw new BlogException(GenerateApiResponse.LOGIN_TO_UPDATE_PROFILE);
        existingAdmin.setEmail(request.getEmail());
        existingAdmin.setName(request.getName());
        existingAdmin.setPassword(request.getPassword());
        existingAdmin.setRole(request.getRole());
        existingAdmin.setUpdatedAt(LocalDateTime.now());

        adminRepository.save(existingAdmin);

        return GenerateApiResponse.updated(GenerateApiResponse.PROFILE_UPDATED_SUCCESSFULLY);

    }
}
