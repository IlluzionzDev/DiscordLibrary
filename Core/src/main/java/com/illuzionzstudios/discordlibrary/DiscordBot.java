package com.illuzionzstudios.discordlibrary;

/**
 * Copyright © 2020 Property of Illuzionz Studios, LLC
 * All rights reserved. No part of this publication may be reproduced, distributed, or
 * transmitted in any form or by any means, including photocopying, recording, or other
 * electronic or mechanical methods, without the prior written permission of the publisher,
 * except in the case of brief quotations embodied in critical reviews and certain other
 * noncommercial uses permitted by copyright law. Any licensing of this software overrides
 * this statement.
 */

import lombok.Getter;
import lombok.Setter;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

/**
 * Main class to extend to create a new discord bot
 */
public abstract class DiscordBot extends Launcher {

    /**
     * Token for the bot
     */
    @Getter
    public static String TOKEN;

    /**
     * Name of our discord bot
     */
    @Getter
    @Setter
    public String name;

    @Getter
    @Setter
    public static String commandPrefix = "!";

    /**
     * Instance of our builder to create the bot
     */
    public JDABuilder botBuilder = new JDABuilder();

    @Override
    public void initialize() {
        try {
            createBot(botBuilder);
        } catch (LoginException ex) {
            ex.printStackTrace();
            System.out.println("Error logging in the bot");
        }

        onBotStartup();
    }

    /**
     * Set our bot token
     *
     * @param token Token to use
     */
    public void setToken(String token) {
        TOKEN = token;
        botBuilder.setToken(TOKEN);
    }

    /**
     * Create an instance of the bot
     *
     * @param jda The JDA instance to build the bot
     */
    public abstract void createBot(JDABuilder jda) throws LoginException;

    /**
     * Called when the bot is created, then starts up
     */
    public abstract void onBotStartup();

}
