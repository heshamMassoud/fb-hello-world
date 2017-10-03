package com.heshammassoud;

import com.github.messenger4j.MessengerPlatform;
import com.github.messenger4j.exceptions.MessengerApiException;
import com.github.messenger4j.exceptions.MessengerIOException;
import com.github.messenger4j.send.MessengerSendClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDocBotApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringDocBotApplication.class);

	/**
	 * Initializes the {@code MessengerSendClient}.
	 *
	 * @param pageAccessToken the generated {@code Page Access Token}
	 */
	@Bean
	public MessengerSendClient messengerSendClient(@Value("${messenger4j.pageAccessToken}") String pageAccessToken) {
		logger.debug("Initializing MessengerSendClient - pageAccessToken: {}", pageAccessToken);
		final MessengerSendClient messengerClient = MessengerPlatform.newSendClientBuilder(pageAccessToken).build();
		try {
			messengerClient.sendTextMessage("129486694374353", "Ya Hesham!");
			messengerClient.sendTextMessage("129486694374353", "Please Answer!");
			messengerClient.sendTextMessage("129486694374353", "me");
			messengerClient.sendTextMessage("129486694374353", "now!");
			messengerClient.sendTextMessage("129486694374353", "please");
			messengerClient.sendTextMessage("129486694374353", "wake up");
			messengerClient.sendTextMessage("129486694374353", "hola");


		} catch (MessengerApiException | MessengerIOException e) {
			logger.error("Message could not be sent. An unexpected error occurred.", e);
		}
		return messengerClient;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDocBotApplication.class, args);
	}
}
