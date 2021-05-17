package com.robert.szebenyi.partnermodule.config;


import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
@Primary
public class PartnerRestServiceConfig extends ResourceConfig {

    @Autowired
    public PartnerRestServiceConfig(List<PartnerRestService> restServices,
                                    Environment environment) {

        restServices.forEach(this::register);

        LoggingFeature component = new LoggingFeature(Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME),
                Level.INFO, LoggingFeature.Verbosity.PAYLOAD_TEXT, 10000);
        register(component);

//        register(ExceptionToResponseMapper.class);
//        register(RequestContextMessagesToResponseFilter.class);
        register(MultiPartFeature.class);


    }

}
