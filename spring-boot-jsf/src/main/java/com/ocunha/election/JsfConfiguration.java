package com.ocunha.election;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class JsfConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(final ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index.xhtml");
	}

	@Bean
	public FacesServlet facesServlet() {
		return new FacesServlet();
	}

	@Bean
	public ServletRegistrationBean dispatcherRegistration(FacesServlet dispatcherServlet) {
		final ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet, "*.xhtml", "/pages/**");
		registration.setName("FacesServlet");
		return registration;
	}

	@Bean
	public ServletContextInitializer contextInitializer(){
		ServletContextInitializer listener = new ServletContextInitializer() {
			@Override
			public void onStartup(ServletContext servletContext)
					throws ServletException {
				servletContext.setInitParameter("primefaces.THEME", "glass-x");
				
			}
		};
		
		return listener;
	}
}
