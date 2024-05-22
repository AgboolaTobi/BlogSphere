package com.BlogSphere.Blog.dtos.requests;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRegistrationRequest {
    private String username;
    private String password;
    private String email;

}
