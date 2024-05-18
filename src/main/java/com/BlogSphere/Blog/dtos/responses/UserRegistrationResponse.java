package com.BlogSphere.Blog.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRegistrationResponse {
    private String message;
    private Long userId;
}
