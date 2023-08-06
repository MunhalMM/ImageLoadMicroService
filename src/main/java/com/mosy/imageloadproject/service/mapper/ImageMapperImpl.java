package com.mosy.imageloadproject.service.mapper;

import com.mosy.imageloadproject.dto.ImageDto;
import com.mosy.imageloadproject.model.Image;
import org.springframework.stereotype.Service;

@Service
public class ImageMapperImpl implements ImageMapper<Image, ImageDto> {

    @Override
    public Image toEntity(ImageDto dto) {
        return new Image(dto.getId(), dto.getBody(),
                dto.getImageName(), dto.getImageSize(), dto.getImageMaxSize(),
                dto.getImageType(), dto.getImageLoadingTime());
    }

    @Override
    public ImageDto toDto(Image entity) {
        return new ImageDto(entity.getId(), entity.getBody(),
                entity.getImageName(), entity.getImageSize(),
                entity.getImageMaxSize(), entity.getImageType(),
                entity.getImageLoadingTime());
    }
}
