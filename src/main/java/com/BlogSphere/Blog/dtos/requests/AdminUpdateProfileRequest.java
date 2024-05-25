package com.BlogSphere.Blog.dtos.requests;

import com.BlogSphere.Blog.data.models.Role;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AdminUpdateProfileRequest {
    private Long id;
    private String name;
    private String password;
    private String email;
    private Role role;
}
