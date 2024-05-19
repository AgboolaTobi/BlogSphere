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
    public static final String INVALID_USER = "Invalid user";
    public static final String BLOG_TITLE_ALREADY_SUBMITTED = "A blog with this title already exist";
    public static final String POST_SUCCESSFULLY_MADE = "Post created successfully";
    public static final String LIKED_SUCCESSFULLY = "Liked successfully";

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

}
