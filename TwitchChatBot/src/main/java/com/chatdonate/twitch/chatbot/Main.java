package com.chatdonate.twitch.chatbot;

import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;

public class Main {

	public static final String BOTNAME	= "botname";
	public static final String OAUTH 	= "oauth:";
	public static final String CHANNEL	= "channel";

	public static PircBotX bot;

	public static void main(String[] args) throws Exception {
		Configuration config = new Configuration.Builder()
				.setName(BOTNAME)
				.setServer("irc.chat.twitch.tv", 6667)
				.setServerPassword(OAUTH)
				.addListener(new Bot())
				.addAutoJoinChannel("#" + CHANNEL)
				.buildConfiguration();

		bot = new PircBotX(config);
		bot.startBot();
	}
}