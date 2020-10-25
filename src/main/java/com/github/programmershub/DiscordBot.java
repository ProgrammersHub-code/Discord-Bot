package com.github.programmershub;

import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.User;
import discord4j.core.object.entity.channel.MessageChannel;

public class DiscordBot {


    public static String PORT = System.getenv("PORT");
    public static String SERVER_URL = System.getenv("SERVER_URL");



    public static void main(String[] args) {
        GatewayDiscordClient client = DiscordClientBuilder.create("NzY5MjY1MTQzNzU0MTI5NDQ5.X5Mf_g._fRzgHrmas-mklSCpHHAMmuJEtY").build().login().block();

        client.getEventDispatcher().on(ReadyEvent.class)
                .subscribe(event -> {
                    User self = event.getSelf();
                    System.out.println(String.format("Logged in as %s#%s", self.getUsername(), self.getDiscriminator()));
                });



        client.on(MessageCreateEvent.class).subscribe((MessageCreateEvent event) -> {
            final Message message = event.getMessage();
            final MessageChannel channel = message.getChannel().block();


            if ("*Poke*".equalsIgnoreCase(message.getContent())) {
            }
            if ("?doot".equalsIgnoreCase(message.getContent())) {
                channel.createMessage("DOOoT DOOT!").block();
            }

        });
        client.onDisconnect().block();
    }


}
