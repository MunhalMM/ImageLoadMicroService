package com.mosy.imageloadproject.apiresponce;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mosy.imageloadproject.dto.ImageDto;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {

    private String error;

    private ImageDto dto;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ImageDto getDto() {
        return dto;
    }

    public void setDto(ImageDto dto) {
        this.dto = dto;
    }

    public static ApiResponse success(ImageDto imageDto) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setDto(imageDto);
        return apiResponse;
    }

    public static ApiResponse error(String errors) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setError(errors);
        return apiResponse;
    }
}
