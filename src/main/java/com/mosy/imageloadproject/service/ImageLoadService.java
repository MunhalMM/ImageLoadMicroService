package com.mosy.imageloadproject.service;

import com.mosy.imageloadproject.imagetype.ImageType;
import com.mosy.imageloadproject.model.Image;

import java.util.Locale;

public interface ImageLoadService {

    Image loadImage(Image image,Locale locale);

    void checkImageSize(Image image, Locale locale);

    ImageType getImageType(Image image,Locale locale);

    void calculateImageSize(Image image);
}
