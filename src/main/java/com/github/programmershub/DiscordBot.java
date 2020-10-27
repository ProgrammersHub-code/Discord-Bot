package com.github.programmershub;

import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.User;
import discord4j.core.object.entity.channel.MessageChannel;

public class DiscordBot {


    private String PORT = System.getenv("PORT");
    private String SERVER_URL = System.getenv("SERVER_URL");


    public static void main(String[] args) {
        String key = System.getenv("BOTKEY");

        GatewayDiscordClient client = DiscordClientBuilder.create(key2).build().login().block();


        client.getEventDispatcher().on(ReadyEvent.class)
                .subscribe(event -> {
                    User self = event.getSelf();
                    System.out.println(String.format("Logged in as %s#%s", self.getUsername(), self.getDiscriminator()));
                });

        client.on(MessageCreateEvent.class).subscribe((MessageCreateEvent event) -> {
            final Message message = event.getMessage();
            final MessageChannel channel = message.getChannel().block();

            switch(message.getContent()){
                case "?doot":
                    channel.createMessage("DOOT DOOT!").block();
                    break;
                case "?doot2":
                    channel.createMessage("DOOT2 DOOT2!").block();
                    break;

                default:
                    break;
            }
        });
        client.onDisconnect().block();
    }

}
