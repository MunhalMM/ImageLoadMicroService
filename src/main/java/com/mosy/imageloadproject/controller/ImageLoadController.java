package com.mosy.imageloadproject.controller;

import com.mosy.imageloadproject.apiresponce.ApiResponse;
import com.mosy.imageloadproject.dto.ImageDto;
import com.mosy.imageloadproject.model.Image;
import com.mosy.imageloadproject.service.ImageLoadService;
import com.mosy.imageloadproject.service.mapper.ImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/images")
public class ImageLoadController {

    private final ImageMapper<Image, ImageDto> imageMapper;

    private final ImageLoadService imageLoadService;

    @Autowired
    public ImageLoadController(ImageMapper<Image, ImageDto> imageMapper, ImageLoadService imageLoadService) {
        this.imageMapper = imageMapper;
        this.imageLoadService = imageLoadService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> load(@RequestBody Image loadImage,
                                            @RequestHeader(value = "Accept-Language", required = false)
                                            Locale locale) {
        Image image = imageLoadService.loadImage(loadImage, locale);
        ImageDto dto = imageMapper.toDto(image);
        return new ResponseEntity<ApiResponse>(ApiResponse.success(dto), HttpStatus.OK);
    }
}
