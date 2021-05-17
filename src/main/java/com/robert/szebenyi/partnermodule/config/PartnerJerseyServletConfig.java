package com.robert.szebenyi.partnermodule.config;

import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PartnerJerseyServletConfig {

    @Bean
    public ServletRegistrationBean partnerJersey(PartnerRestServiceConfig serviceConfig) {
        ServletRegistrationBean partnerJersey
                = new ServletRegistrationBean(new ServletContainer(serviceConfig));
        partnerJersey.addUrlMappings("/partner/*");
        partnerJersey.setName("PartnerJersey");
        partnerJersey.setLoadOnStartup(0);
        return partnerJersey;
    }
}
