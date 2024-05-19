package com.BlogSphere.Blog.utils;


import org.springframework.http.HttpStatus;

public class GenerateApiResponse {


    public static final String REGISTRATION_DETAILS_ALREADY_TAKEN = "Email is already registered";
    public static final String REGISTRATION_SUCCESSFUL = "Registration successful";
    public static final String INVALID_PASSWORD_FORMAT = """
             password has a minimum of 8 characters
             At least 1 uppercase letter,\s
             At least 1 lowercase letter, and 1 number with no spaces
         \s""";
    public static final String INVALID_EMAIL_FORMAT = "Invalid email format";
    public static final String BLOG_SUCCESSFULLY_CREATED = "Blog successfully created";
    public static final String POST_SUCCESSFULLY_MADE = "Post created successfully";
    public static final String COMMENT_SUCCESSFULLY_SUBMITTED = "Comment submission successfully";
    public static final String POST_UPDATED_SUCCESSFULLY = "Post updated successfully";
    public static final String BLOG_UPDATED_SUCCESSFULLY = "Blog updated successfully";
    public static final String BLOG_NOT_FOUND = "Blog not found";
    public static final String USER_PROFILE_UPDATED_SUCCESSFULLY = "User profile updated successfully";
    public static final String LIST_POSTS_RETURNED = "Blog posts";

    public static ApiResponse created(Object data) {

        return ApiResponse.builder()
                .data(data)
                .httpStatus(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .isSuccessful(true)
                .build();
    }

    public static ApiResponse OK(Object data) {

        return ApiResponse.builder()
                .data(data)
                .httpStatus(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .isSuccessful(true)
                .build();
    }

    public static ApiResponse updated(Object data) {
        return ApiResponse.builder()
                .data(data)
                .httpStatus(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .isSuccessful(true)
                .build();
    }
}
