package com.epam.mentorship.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ImportResource("classpath:persistance-config.xml")
@ComponentScan("com.epam.mentorship")
@EnableWebMvc
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class ApplicationConfiguration extends WebMvcConfigurerAdapter {
	private static final Logger LOG = Logger.getLogger(ApplicationConfiguration.class);

	@Bean
	public ViewResolver internalResourceViewResolver() {
		LOG.info("configuring view resolver");
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
