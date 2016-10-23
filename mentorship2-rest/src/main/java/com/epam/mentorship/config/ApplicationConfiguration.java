package com.epam.mentorship.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.Marshaller;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.MediaType;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MarshallingView;

import com.epam.mentorship.model.Mentee;
import com.epam.mentorship.model.Mentor;
import com.epam.mentorship.model.MentorshipProgram;
import com.epam.mentorship.model.User;

@ImportResource("classpath:persistance-config.xml")
@ComponentScan("com.epam.mentorship")
@EnableWebMvc
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class ApplicationConfiguration extends WebMvcConfigurerAdapter {
	private static final Logger LOG = Logger.getLogger(ApplicationConfiguration.class);

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		LOG.info("content negotiation configuration");
		configurer.favorPathExtension(true).ignoreAcceptHeader(true).defaultContentType(MediaType.APPLICATION_JSON)
				.useJaf(false).mediaType("xml", MediaType.APPLICATION_XML);
	}

	@Bean
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
		LOG.info("content negotiation view resolvers configuration");
		
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setContentNegotiationManager(manager);

		List<View> defaultViews = new ArrayList<>();
		defaultViews.add(new MappingJackson2JsonView());

		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		Map<String, Object> marshallerProperties = new HashMap<>();
		marshallerProperties.put(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxb2Marshaller.setMarshallerProperties(marshallerProperties);
		jaxb2Marshaller.setClassesToBeBound(User.class, MentorshipProgram.class, Mentor.class, Mentee.class);
		defaultViews.add(new MarshallingView(jaxb2Marshaller));

		resolver.setDefaultViews(defaultViews);
		return resolver;
	}
}
