package com.qa;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.client.RestTemplate;

import java.util.Properties;

@SpringBootApplication
public class CvGeneratorApplication {


	@Value("${mail.smtp}")
	private String mailSmtp;

	@Value("${mail.username}")
	private String email;

	@Value("${mail.password}")
	private String ePass;

	@Value("${mail.transport.protocol}")
	private String mailTransP;

	@Value("${mail.smtp.auth}")
	private String mailsmtpauth;

	@Value("${mail.smtp.starttls.enable}")
	private String startTls;

	@Value("${mail.debug}")
	private String maildebug;

	@Value("${mail.smtp.ssl.trust}")
	private String sslTrust;

	@Value("${mail.true}")
	private String strTrue;

	@Value("${mail.prot}")
	private String protcol;

	public static void main(String[] args) {
		SpringApplication.run(CvGeneratorApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
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
	public JavaMailSender javaMailSender(){
		JavaMailSenderImpl mailSender =  new JavaMailSenderImpl();
		mailSender.setHost(mailSmtp);
		mailSender.setPort(587);
		mailSender.setUsername(email);
		mailSender.setPassword(ePass);

		Properties props = mailSender.getJavaMailProperties();
		props.put(mailTransP, protcol);
		props.put(mailsmtpauth, strTrue);
		props.put(startTls, strTrue);
		props.put(maildebug, strTrue);
		props.put(sslTrust, "*");

		return mailSender;
	}
}
