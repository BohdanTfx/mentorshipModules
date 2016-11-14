package com.epam.mentorship.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.epam.mentorship.dao.LogEntryDao;

@ComponentScan("com.epam.mentorship")
@EnableWebMvc
@EnableAspectJAutoProxy
@Configuration
@EnableMongoRepositories(
        basePackageClasses = LogEntryDao.class)
public class ApplicationConfiguration extends WebMvcConfigurerAdapter {
    private static final Logger LOG = Logger
            .getLogger(ApplicationConfiguration.class);

    @Bean
    public ViewResolver internalResourceViewResolver() {
        LOG.info("configuring view resolver");
        InternalResourceViewResolver resolver
        = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(
            final DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
