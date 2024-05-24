package com.BlogSphere.Blog.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AdminRegistrationRequest {
    private String name;
    private String password;
    private String email;
}
