package com.mosy.imageloadproject.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ImageRouteBuilder extends RouteBuilder {

    @Value("${pathToOutQueueForImage}")
    private String pathToOutQueueForImage;

    @Value("${pathToInQueueForImage}")
    private String pathToInQueueForImage;

    @Override
    public void configure() throws Exception {

        from(pathToInQueueForImage)
                .routeId("inoutRoute")
                .to(pathToOutQueueForImage)
                .stop();
    }
}
