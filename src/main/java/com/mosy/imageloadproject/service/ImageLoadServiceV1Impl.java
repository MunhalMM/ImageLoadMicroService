package com.mosy.imageloadproject.service;

import com.mosy.imageloadproject.exceptions.SizeLimitException;
import com.mosy.imageloadproject.imagetype.ImageType;
import com.mosy.imageloadproject.model.Image;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.ExchangeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Locale;


@Service
@Profile("dev")
public class ImageLoadServiceV1Impl implements ImageLoadService {

    @Value("${image.imageMaxSize}")
    private long imageMaxSize;

    @Value("${pathToInQueueForImage}")
    private String pathToInQueueForImage;

    private final ProducerTemplate producerTemplate;

    private final CamelContext context;

    private final MessageSource messageSource;

    @Autowired
    public ImageLoadServiceV1Impl(ProducerTemplate producerTemplate, CamelContext context, MessageSource messageSource) {
        this.producerTemplate = producerTemplate;
        this.context = context;
        this.messageSource = messageSource;
    }

    @Override
    public Image loadImage(Image image, Locale locale) {
        ImageType imageType = getImageType(image,locale);
        image.setImageType(imageType);
        calculateImageSize(image);
        checkImageSize(image,locale);
        Exchange exchange = ExchangeBuilder.anExchange(context)
                .withHeader("filename", image.getImageName())
                .withHeader("size", image.getImageSize())
                .withHeader("type", image.getImageType().name())
                .withHeader("originalBody", image.getBody())
                .withBody(image.getBody())
                .build();
        producerTemplate.send(pathToInQueueForImage, exchange);
        return image;
    }

    @Override
    public void checkImageSize(Image image, Locale locale) {
        if (image.getImageSize() >= imageMaxSize) {
            String message = String.format(messageSource.getMessage("image.size.limit.exception", null, locale), imageMaxSize);
            throw new SizeLimitException(message);
        }
    }

    @Override
    public ImageType getImageType(Image image, Locale locale) {
        String imageName = image.getImageName();
        for (ImageType imageType : ImageType.values()) {
            if (imageName.endsWith(imageType.getName())) {
                return imageType;
            }
        }
        String message = messageSource.getMessage("illegal.argument.exception", null, locale);
        throw new IllegalArgumentException(message);
    }

    @Override
    public void calculateImageSize(Image image) {
        image.setImageSize((long) image.getBody().length);
    }
}
