package com.mosy.imageloadproject.dto;

import com.mosy.imageloadproject.imagetype.ImageType;
import com.mosy.imageloadproject.service.mapper.Entity;

import java.time.LocalDateTime;
import java.util.Arrays;

public class ImageDto implements Entity {
    private Long id;

    private byte[] body;

    private String imageName;

    private Long imageSize;

    private Long imageMaxSize;
    private ImageType imageType;

    private LocalDateTime imageLoadingTime;

    public ImageDto(Long id, byte[] body, String imageName, Long imageSize, Long imageMaxSize, ImageType imageType, LocalDateTime imageLoadingTime) {
        this.id = id;
        this.body = body;
        this.imageName = imageName;
        this.imageSize = imageSize;
        this.imageMaxSize = imageMaxSize;
        this.imageType = imageType;
        this.imageLoadingTime = imageLoadingTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Long getImageSize() {
        return imageSize;
    }

    public void setImageSize(Long imageSize) {
        this.imageSize = imageSize;
    }

    public Long getImageMaxSize() {
        return imageMaxSize;
    }

    public void setImageMaxSize(Long imageMaxSize) {
        this.imageMaxSize = imageMaxSize;
    }

    public ImageType getImageType() {
        return imageType;
    }

    public void setImageType(ImageType imageType) {
        this.imageType = imageType;
    }

    public LocalDateTime getImageLoadingTime() {
        return imageLoadingTime;
    }

    public void setImageLoadingTime(LocalDateTime imageLoadingTime) {
        this.imageLoadingTime = imageLoadingTime;
    }

    @Override
    public String toString() {
        return "ImageDto{" +
                "id=" + id +
                ", body=" + Arrays.toString(body) +
                ", imageName='" + imageName + '\'' +
                ", imageSize=" + imageSize +
                ", imageMaxSize=" + imageMaxSize +
                ", imageType=" + imageType +
                ", imageLoadingTime=" + imageLoadingTime +
                '}';
    }
}
