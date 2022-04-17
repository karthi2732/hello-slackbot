package com.learn.slackbot;

import com.slack.api.bolt.App;
import com.slack.api.bolt.AppConfig;
import com.slack.api.model.event.MessageEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@ServletComponentScan
public class SlackbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlackbotApplication.class, args);
	}

	@Bean(name = "app")
	public App initSlackApp(){


		AppConfig appConfig = new AppConfig();
		appConfig.setSigningSecret("xxxxx-signing-secret-xxxxx");
		appConfig.setSingleTeamBotToken("xxxxx-bot-token-xxxxx");

		App app = new App(appConfig);

		app.command("/hello", (req, ctx) -> {
			System.out.println(req.getRequestBodyAsString());
			return ctx.ack("What's up?");
		});


		app.event(MessageEvent.class, (payload, ctx) -> {

			ctx.say("Hello");
			return ctx.ack();
		});

		return app;

	}

}
