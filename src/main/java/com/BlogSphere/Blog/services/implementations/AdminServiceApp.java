package com.BlogSphere.Blog.services.implementations;

import com.BlogSphere.Blog.data.models.Admin;
import com.BlogSphere.Blog.data.models.Role;
import com.BlogSphere.Blog.data.repositories.AdminRepository;
import com.BlogSphere.Blog.dtos.requests.AdminLoginRequest;
import com.BlogSphere.Blog.dtos.requests.AdminRegistrationRequest;
import com.BlogSphere.Blog.dtos.responses.AdminLoginResponse;
import com.BlogSphere.Blog.dtos.responses.AdminRegistrationResponse;
import com.BlogSphere.Blog.exceptions.BlogException;
import com.BlogSphere.Blog.services.interfaces.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class AdminServiceApp implements AdminService {
    private final AdminRepository adminRepository;

    @Override
    public AdminRegistrationResponse registerAdmin(AdminRegistrationRequest request) throws BlogException {
        boolean isRegistered = adminRepository.findByEmail(request.getEmail())!=null;
        if (isRegistered) throw new BlogException("Email already taken");
        Admin admin = new Admin();
        admin.setName(request.getName());
        admin.setEmail(request.getEmail());
        admin.setPassword(request.getPassword());
        admin.setRole(Role.ADMIN);
        admin.setCreatedAt(LocalDateTime.now());
        adminRepository.save(admin);

        AdminRegistrationResponse response = new AdminRegistrationResponse();
        response.setId(admin.getId());
        response.setMessage("Admin successfully registered");

        return response;
    }

    @Override
    public AdminLoginResponse login(AdminLoginRequest request) throws BlogException {
        Admin existingAdmin = adminRepository.findByEmail(request.getEmail());
        if (existingAdmin==null) throw new BlogException("Incorrect email");
        if (!existingAdmin.getPassword().equals(request.getPassword())) throw new BlogException("Incorrect password");

        existingAdmin.setLogin(true);
        adminRepository.save(existingAdmin);
        AdminLoginResponse response = new AdminLoginResponse();
        response.setMessage("Admin successfully logged in");
        return response;
    }
}
