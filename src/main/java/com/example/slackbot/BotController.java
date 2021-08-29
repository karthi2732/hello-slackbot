package com.example.slackbot;

import com.slack.api.bolt.App;
import com.slack.api.bolt.servlet.SlackAppServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/slack/events")
public class BotController extends SlackAppServlet {

    public BotController(App app){
        super(app);
    }

}
