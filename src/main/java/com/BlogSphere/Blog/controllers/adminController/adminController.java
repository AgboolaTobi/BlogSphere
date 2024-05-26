package com.BlogSphere.Blog.controllers.adminController;


import com.BlogSphere.Blog.dtos.requests.AdminRegistrationRequest;
import com.BlogSphere.Blog.exceptions.BlogException;
import com.BlogSphere.Blog.services.interfaces.AdminService;
import com.BlogSphere.Blog.utils.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admin/")
@AllArgsConstructor
public class adminController {

    private final AdminService adminService;

    @PostMapping("register")
    public ResponseEntity<ApiResponse> createAdmin(@Valid @RequestBody AdminRegistrationRequest request) throws BlogException {
        return new ResponseEntity<>(adminService.registerAdmin(request), HttpStatus.CREATED);
    }
}
