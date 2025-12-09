package com.setec.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

import lombok.Data;

@Service
@Data
public class MyTelegramBot {
	@Value("${token}")
	private String token;
	@Value("${chart_id}")
	private long chart_id;
	
	private TelegramBot bot;
	
	public SendResponse sendMessage(String text) {
		if(bot ==null) {
			bot = new TelegramBot(token);
		}
		SendResponse message
		= bot.execute(new SendMessage(chart_id, text));
		return message;
	}
	
}
