package com.qa;

import javax.jms.ConnectionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJms
public class ConsumerApplication {
	
	Logger logger = LoggerFactory.getLogger(ConsumerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
	
	  @Bean
	  JmsListenerContainerFactory<?> jmsContainerFactory(ConnectionFactory connectionFactory) {
		  SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
		  factory.setConnectionFactory(connectionFactory);
		  factory.setErrorHandler(t -> {
	    	  logger.error("Error in listener!", t);
	         });
	      return factory;
		  
	  }
		@Bean
		public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
				DefaultJmsListenerContainerFactoryConfigurer configurer) {
			DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
			configurer.configure(factory, connectionFactory);
			return factory;
		}

		@Bean
		public MessageConverter jacksonJmsMessageConverter() {
			MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
			converter.setTargetType(MessageType.TEXT);
			converter.setTypeIdPropertyName("_type");
			return converter;
		}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}

