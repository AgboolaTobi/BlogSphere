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
    public static final String BLOG_UPDATED_SUCCESSFULLY = "Blog updated successfully";
    public static final String BLOG_NOT_FOUND = "Blog not found";
    public static final String PROFILE_UPDATED_SUCCESSFULLY = "User profile updated successfully";
    public static final String ADMIN_SUCCESSFULLY_REGISTERED = "Admin successfully registered";
    public static final String INCORRECT_EMAIL = "Incorrect email";
    public static final String LOGIN_TO_UPDATE_PROFILE = "Kindly login to update profile";
    public static final String LOGIN_SUCCESSFULLY = "Login successful";
    public static final String ADMIN_NOT_FOUND = "Admin not found";
    public static final String ALL_FIELDS_ARE_MANDATORY = """
            1. Email is mandatory
            2. Password is mandatory
            3. Email is mandatory
            """;

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
