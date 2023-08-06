package com.mosy.imageloadproject.model;

import com.mosy.imageloadproject.imagetype.ImageType;
import com.mosy.imageloadproject.service.mapper.Entity;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Image implements Entity {

    private Long id;

    private byte[] body;

    private String imageName;

    private Long imageSize;

    private Long imageMaxSize;
    private ImageType imageType;

    private LocalDateTime imageLoadingTime;

    public Image() {
        //
    }

    public Image(Long id, byte[] body, String imageName, Long imageSize, Long imageMaxSize, ImageType imageType, LocalDateTime imageLoadingTime) {
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

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String pictureName) {
        this.imageName = pictureName;
    }

    public Long getImageSize() {
        return imageSize;
    }

    public void setImageSize(Long pictureCapacity) {
        this.imageSize = pictureCapacity;
    }

    public ImageType getImageType() {
        return imageType;
    }

    public void setImageType(ImageType pictureType) {
        this.imageType = pictureType;
    }

    public LocalDateTime getImageLoadingTime() {
        return imageLoadingTime;
    }

    public void setImageLoadingTime(LocalDateTime pictureLoadingTime) {
        this.imageLoadingTime = pictureLoadingTime;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    public Long getImageMaxSize() {
        return imageMaxSize;
    }

    public void setImageMaxSize(Long imageMaxSize) {
        this.imageMaxSize = imageMaxSize;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", body=" + Arrays.toString(body) +
                ", imageName='" + imageName + '\'' +
                ", imageSize=" + imageSize +
                ", imageType=" + imageType +
                ", imageLoadingTime=" + imageLoadingTime +
                '}';
    }
}
